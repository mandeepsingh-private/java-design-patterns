package com.mandeep.designPatterns.behavioral.strategy;

public class Calculator {

	public static void main(String[] args) {
		Calculation c = new Calculation(new Add());
		c.executeCalculation(1.0, 2.0);
		c.setStrategy(new Subtract());
		c.executeCalculation(1.0, 2.0);
		c.setStrategy(new Multiply());
		c.executeCalculation(1.0, 2.0);
		c.setStrategy(new Divide());
		c.executeCalculation(1.0, 2.0);

	}

}

class Calculation {
	private CalculationStrategy strategy;

	public Calculation(CalculationStrategy strategy) {
		this.strategy = strategy;
	}

	public CalculationStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(CalculationStrategy strategy) {
		this.strategy = strategy;
	}

	public void executeCalculation(Double a, Double b) {
		this.strategy.calculate(a, b);
	}
}

interface CalculationStrategy {
	void calculate(Double a, Double b);

	void display();
}

/*
 * Algorithm: Addition
 */
class Add implements CalculationStrategy {
	private Double a;
	private Double b;
	private Double answer;

	public void calculate(Double a, Double b) {
		this.a = a;
		this.b = b;
		this.answer = a + b;
		display();

	}

	public void display() {
		System.out.println("Sum is: " + answer);

	}
}

/*
 * Algorithm: Subtraction
 */

class Subtract implements CalculationStrategy {
	private Double a;
	private Double b;
	private Double answer;

	public void calculate(Double a, Double b) {
		this.a = a;
		this.b = b;
		this.answer = a - b;
		display();

	}

	public void display() {
		System.out.println("Subtraction is: " + answer);

	}
}

/*
 * Algorithm: Multiply
 */

class Multiply implements CalculationStrategy {
	private Double a;
	private Double b;
	private Double answer;

	public void calculate(Double a, Double b) {
		this.a = a;
		this.b = b;
		this.answer = a * b;
		display();

	}

	public void display() {
		System.out.println("Multiplication is: " + answer);

	}
}

/*
 * Algorithm: Divide
 */

class Divide implements CalculationStrategy {
	private Double a;
	private Double b;
	private Double answer;

	public void calculate(Double a, Double b) {
		this.a = a;
		this.b = b;
		this.answer = a / b;
		display();

	}

	public void display() {
		System.out.println("Division is: " + answer);

	}
}