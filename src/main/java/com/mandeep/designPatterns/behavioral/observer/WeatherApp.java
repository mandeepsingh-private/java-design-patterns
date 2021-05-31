package com.mandeep.designPatterns.behavioral.observer;

/*
 * The Observer Pattern defines a one-to-many
dependency between objects so that when one
object changes state, all of its dependents are
notified and updated automatically.
 */
import java.util.ArrayList;

public class WeatherApp {
	public static void main(String[] args) {
		// start the weather station
		WeatherStation weatherStation = new WeatherStation();
		// start the subscribers
		Radio radio = new Radio(weatherStation);
		TV tv = new TV(weatherStation);
		weatherStation.setMeasurements(80, 65, 30.4f);
		weatherStation.setMeasurements(82, 70, 29.2f);
		weatherStation.setMeasurements(78, 90, 29.2f);
	}
}

//SUBJECT OR PUBLISHER
interface IPublisher {
	public void regsiterSubscriber(ISubscriber s);

	public void removeSubscriber(ISubscriber s);

	public void notifySubscribers();
}

//OBSERVERS or SUBSCRIBERS
interface ISubscriber {
	public void update(float temp, float humidity, float pressure);
}

interface IDisplay {
	public void display();
}

class WeatherStation implements IPublisher {
	private ArrayList<ISubscriber> subscribers;
	private float temp;
	private float humidity;
	private float pressure;

	WeatherStation() {
		subscribers = new ArrayList<>();
	}

	public void regsiterSubscriber(ISubscriber s) {
		subscribers.add(s);
	}

	public void removeSubscriber(ISubscriber s) {
		int indexToRemove = subscribers.indexOf(s);
		if (indexToRemove > 0) {
			subscribers.remove(indexToRemove);
		}
	}

	public void notifySubscribers() {
		for (int i = 0; i < subscribers.size(); i++) {
			subscribers.get(i).update(temp, humidity, pressure);
		}

	}

	public void measurementsChanged() {
		notifySubscribers();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temp = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}

}

class Radio implements IDisplay, ISubscriber {
	private float temp;
	private float humidity;
	private float pressure;
	private IPublisher WeatherStation;

	public Radio(IPublisher publisher) {
		this.WeatherStation = publisher;
		publisher.regsiterSubscriber(this);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("Radio Current conditions: " + temp
				+ "F degrees and " + humidity + "% humidity");
	}

}

class TV implements IDisplay, ISubscriber {
	private float temp;
	private float humidity;
	private float pressure;
	private IPublisher WeatherStation;

	public TV(IPublisher publisher) {
		this.WeatherStation = publisher;
		publisher.regsiterSubscriber(this);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("TV Current conditions: " + temp + "F degrees and "
				+ humidity + "% humidity");
	}

}
