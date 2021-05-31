package com.mandeep.designPatterns.behavioral.strategy;

/**
 * 
 * The Strategy Pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. Strategy lets the algorithm vary
 * independently from clients that use it.
 *
 */
public class DuckSimulator {

	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();
		mallardDuck.display();
		mallardDuck.performQuack();
		mallardDuck.performFly();

		ModelDuck modelDuck = new ModelDuck();
		modelDuck.display();
		modelDuck.performFly();
		// swap or interchange the algorithm. the duck which cANNOT FLY, WE
		// CHNAGE IT TO FLY WITH Rocket
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		modelDuck.performFly();
	}

}

abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

//setters
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}

interface FlyBehavior {
	public void fly();
}

/**
 * 
 * Algorithm 1: FLY Behavior
 *
 */

// 1. fly with wings
class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("I’m flying!!");
	}
}

//2. cannot fly 
class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can’t fly");
	}
}

//3. fly with rocket
class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("I’m flying with a rocket!");
	}
}

/**
 * 
 * Algorithm 2: Quack Behavior
 *
 */
interface QuackBehavior {
	public void quack();
}

class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack");
	}
}

class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}

class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}

// create Mallard Duck
class MallardDuck extends Duck {
	// apply behaviors
	public MallardDuck() {
		// Behaviors are defined in parent class Duck
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("##### I’m a real Mallard duck");
	}
}

//create model duck
class ModelDuck extends Duck {
	// cannot fly
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("### I’m a model duck");
	}
}