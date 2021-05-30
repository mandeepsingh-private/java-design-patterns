package com.mandeep.designPatterns.Factory;

public class LogisticsApp {

	public static void main(String[] args) {
		Logistics logistics = new RoadLogistics();
		logistics.deliveryMethod("Truck").ship();
		logistics = new SeaLogistics();
		logistics.deliveryMethod("CargoBoat").ship();
	}

}

/*
 * Factory
 */
abstract class Logistics {
	abstract Transport deliveryMethod(String type);

}

class RoadLogistics extends Logistics {

	@Override
	Transport deliveryMethod(String type) {
		Transport roadLogistics = null;
		if (type == "smalltruck") {
			roadLogistics = new SmallTruck();
		} else if (type == "Truck") {
			roadLogistics = new Truck();
		} else if (type == "OversizeTruck") {
			roadLogistics = new OversizeTruck();
		}
		return roadLogistics;
	}

}

class SeaLogistics extends Logistics {

	@Override
	Transport deliveryMethod(String type) {
		Transport seaLogistics = null;
		if (type == "ship") {
			seaLogistics = new Ship();
		} else if (type == "CargoBoat") {
			seaLogistics = new CargoBoat();
		}
		return seaLogistics;
	}

}

/*
 * Products
 */
abstract class Transport {
	abstract void ship();
}

class SmallTruck extends Transport {

	@Override
	void ship() {
		System.out.println("Shipping by small truck");

	}

}

class Truck extends Transport {

	@Override
	void ship() {
		System.out.println("Shipping by truck");

	}

}

class OversizeTruck extends Transport {

	@Override
	void ship() {
		System.out.println("Shipping by OversizeTruck");

	}

}

class Ship extends Transport {

	@Override
	void ship() {
		System.out.println("Shipping by ship");

	}

}

class CargoBoat extends Transport {

	@Override
	void ship() {
		System.out.println("Shipping by CargoBoat");

	}

}

class Airplane extends Transport {

	@Override
	void ship() {
		System.out.println("Shipping by Airplane");

	}

}
