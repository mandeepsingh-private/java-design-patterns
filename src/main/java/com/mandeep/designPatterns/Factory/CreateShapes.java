package com.mandeep.designPatterns.Factory;

public class CreateShapes {
	public static void main(String[] args) {

		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape = shapeFactory.createShape("Rectangle");
		shape.draw();
		shape = shapeFactory.createShape("Circle");
		shape.draw();
		shape = shapeFactory.createShape("triangle");
		shape.draw();
	}
}

/*
 * Factory
 */
class ShapeFactory {

	public Shape createShape(String type) {
		Shape shape = null;

		if (type.toLowerCase().equals("rectangle")) {
			shape = new Rectangle();
		} else if (type.toLowerCase().equals("circle")) {
			shape = new Circle();
		} else if (type.toLowerCase().equals("triangle")) {
			shape = new Triangle();
		}
		return shape;
	}
}

/*
 * product to manufacture
 */
abstract class Shape {
	abstract void draw();
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("Creating Rectangle");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("Creating Circle");
	}
}

class Triangle extends Shape {
	void draw() {
		System.out.println("Creating Triangle");
	}
}