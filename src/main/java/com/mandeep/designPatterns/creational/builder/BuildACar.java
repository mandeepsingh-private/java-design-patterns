package com.mandeep.designPatterns.creational.builder;

/*
 * A car is a complex object that can be constructed in a hundred different ways. 
 * Instead of bloating the Car class with a huge constructor, we extracted the car assembly code into a separate car builder class. 
 * This class has a set of methods for configuring various parts of a car. 
 * If some part is not configured it is null by default
 */
public class BuildACar {

	public static void main(String[] args) {
		CarBuilder carBuilder = new CarBuilder();
		// lets build a sport car
		carBuilder.setCarType(CarType.SPORTS_CAR);
		carBuilder.setSeats(2);
		carBuilder.setEngine(new Engine(3.0, 0));
		// builder.setTransmission(Transmission.SEMI_AUTOMATIC);
		carBuilder.setTripComputer(new TripComputer());
		carBuilder.setGPSNavigator(new GPSNavigator());
		// The final product is often retrieved from a builder object, since
		// Director is not aware and not dependent on concrete builders and
		// products.
		Car car = carBuilder.createCar();
		System.out.println("Car built: " + car.getCarType());
		// if a field is not used in constructions it will be null
		System.out.println("Car Transmission: " + car.getTransmission());
	}

}

/**
 * Builder interface defines all possible ways to configure a product.
 */
interface Builder {
	void setCarType(CarType type);

	void setSeats(int seats);

	void setEngine(Engine engine);

	void setTransmission(Transmission transmission);

	void setTripComputer(TripComputer tripComputer);

	void setGPSNavigator(GPSNavigator gpsNavigator);
}

class CarBuilder implements Builder {
	private CarType type;
	private int seats;
	private Engine engine;
	private Transmission transmission;
	private TripComputer tripComputer;
	private GPSNavigator gpsNavigator;

	public void setCarType(CarType type) {
		this.type = type;
	}

	@Override
	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	@Override
	public void setTripComputer(TripComputer tripComputer) {
		this.tripComputer = tripComputer;
	}

	@Override
	public void setGPSNavigator(GPSNavigator gpsNavigator) {
		this.gpsNavigator = gpsNavigator;
	}

	// create actual car by calling car class constructor
	public Car createCar() {
		return new Car(type, seats, engine, transmission, tripComputer,
				gpsNavigator);
	}
}

class Car {
	private final CarType carType;
	private final int seats;
	private final Engine engine;
	private final Transmission transmission;
	private final TripComputer tripComputer;
	private final GPSNavigator gpsNavigator;
	private double fuel = 0;

	public Car(CarType carType, int seats, Engine engine,
			Transmission transmission, TripComputer tripComputer,
			GPSNavigator gpsNavigator) {
		this.carType = carType;
		this.seats = seats;
		this.engine = engine;
		this.transmission = transmission;
		this.tripComputer = tripComputer;
		if (this.tripComputer != null) {
			this.tripComputer.setCar(this);
		}
		this.gpsNavigator = gpsNavigator;
	}

	public CarType getCarType() {
		return carType;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public int getSeats() {
		return seats;
	}

	public Engine getEngine() {
		return engine;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public TripComputer getTripComputer() {
		return tripComputer;
	}

	public GPSNavigator getGpsNavigator() {
		return gpsNavigator;
	}
}

/**
 * Components of car,
 */
class Engine {
	private final double volume;
	private double mileage;
	private boolean started;

	public Engine(double volume, double mileage) {
		this.volume = volume;
		this.mileage = mileage;
	}

	public void on() {
		started = true;
	}

	public void off() {
		started = false;
	}

	public boolean isStarted() {
		return started;
	}

	public void go(double mileage) {
		if (started) {
			this.mileage += mileage;
		} else {
			System.err.println("Cannot go(), you must start engine first!");
		}
	}

	public double getVolume() {
		return volume;
	}

	public double getMileage() {
		return mileage;
	}
}

class GPSNavigator {
	private String route;

	public GPSNavigator() {
		this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
	}

	public GPSNavigator(String manualRoute) {
		this.route = manualRoute;
	}

	public String getRoute() {
		return route;
	}
}

enum Transmission {
	SINGLE_SPEED, MANUAL, AUTOMATIC, SEMI_AUTOMATIC
}

enum CarType {
	CITY_CAR, SPORTS_CAR, SUV
}

class TripComputer {

	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}

	public void showFuelLevel() {
		System.out.println("Fuel level: " + car.getFuel());
	}

	public void showStatus() {
		if (this.car.getEngine().isStarted()) {
			System.out.println("Car is started");
		} else {
			System.out.println("Car isn't started");
		}
	}
}
