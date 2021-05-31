package com.mandeep.designPatterns.structural.decorator;

public class StarbuzzCoffee {
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Soy(beverage2);
		System.out
				.println(beverage2.getDescription() + " $" + beverage2.cost());
	}
}

/*
 * Beverage
 */
abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();

}

/*
 * TYPES of BEVERAGE
 */
class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}

	public double cost() {
		return 1.99;
	}
}

class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "HouseBlend";
	}

	public double cost() {
		return 0.89;
	}
}

class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf";
	}

	public double cost() {
		return 1.90;
	}
}

class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "DarkRoast";
	}

	public double cost() {
		return 3.90;
	}
}

/*
 * CONDIMENTS
 */
abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}

class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}

/*
 * Types of CONDIMENTS
 */
class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}

class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return .30 + beverage.cost();
	}

}
