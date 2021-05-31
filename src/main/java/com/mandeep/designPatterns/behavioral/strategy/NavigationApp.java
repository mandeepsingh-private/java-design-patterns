package com.mandeep.designPatterns.behavioral.strategy;

/**
 * 
 * The Strategy Pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. Strategy lets the algorithm vary
 * independently from clients that use it.
 *
 */

public class NavigationApp {

	public static void main(String[] args) {
		Route br = new Route(new Bycycle());
		br.generateRoute("Newyork", "Buffalo");
		br.setStrategy(new PublicTransport());
		br.generateRoute("Newyork", "Buffalo");

	}

}

class Route {
	private RouteStrategy strategy;

	public Route(RouteStrategy strategy) {

		this.strategy = strategy;
	}

	public RouteStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(RouteStrategy strategy) {
		this.strategy = strategy;
	}

	void generateRoute(String A, String B) {
		this.strategy.buildRoute(A, B);
	}
}

interface RouteStrategy {

	public abstract void display();

	public void buildRoute(String A, String B);

}

class Bycycle implements RouteStrategy {
	String start;
	String end;
	int time;

	public void display() {
		System.out.println("Using Bycycle: " + "Start: " + start + "End: " + end
				+ "time - " + time + " hrs");

	}

	public void buildRoute(String A, String B) {
		this.start = A;
		this.end = B;
		this.time = time + 1000;
		display();
	}

}

class PublicTransport implements RouteStrategy {
	String start;
	String end;
	int time;

	public void display() {
		System.out.println("Using PublicTransport: " + "Start: " + start
				+ "End: " + end + "time - " + time + " mins");

	}

	public void buildRoute(String A, String B) {
		this.start = A;
		this.end = B;
		this.time = time + 50;
		display();
	}

}