package com.mandeep.designPatterns.decorator;

public class DesignShape {
	public static void main(String[] args) {
		Shape sh = new Rectangle();
		sh = new DrawBorder(sh);
		sh = new FillColor(sh);
		sh = new AddText(sh);
		((AddText) sh).setText("Z");
		System.out.println(sh.draw());

	}
}

abstract class Shape {
	String name = "undefined";

	protected abstract String draw();

}

class Rectangle extends Shape {
	public Rectangle() {
		name = "Rectangle";
	}

	@Override
	protected String draw() {
		return "Completed Drawing Rectangle";
	}

}

class Triangle extends Shape {
	public Triangle() {
		name = "Triangle";
	}

	@Override
	protected String draw() {

		return "Completed Drawing Triangle";
	}

}

class Circle extends Shape {
	public Circle() {
		name = "Circle";
	}

	@Override
	protected String draw() {

		return "Completed Drawing Circle";
	}

}

abstract class ShapeDecorator extends Shape {
	public abstract String draw();
}

class DrawBorder extends ShapeDecorator {
	public Shape shape;

	public DrawBorder(Shape shape) {
		this.shape = shape;

	}

	@Override
	public String draw() {
		return "Adding border \n" + this.shape.draw();
	}

}

class FillColor extends ShapeDecorator {
	public Shape shape;

	public FillColor(Shape shape) {
		this.shape = shape;

	}

	@Override
	public String draw() {
		return "Filling Color \n" + this.shape.draw();

	}

}

class AddText extends ShapeDecorator {
	public Shape shape;
	String text;

	public AddText(Shape shape) {
		this.shape = shape;

	}

	@Override
	public String draw() {
		return "Adding Text " + this.text + " \n" + this.shape.draw();

	}

	protected void setText(String text) {
		this.text = text;
	}

}