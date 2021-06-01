package com.mandeep.designPatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/*
 * Instead of writing if, then else logic for calculating height based on shape
 * you can use visitor pattern for elegant code
 * You can use Visitor along with Iterator to traverse 
 * a complex data structure and execute some operation 
 * over its elements, even if they all have different classes.
 */
public class CalculateHeightOfShapes {

	public static void main(String[] args) {
		List<IShape> shapes = new ArrayList<IShape>();
		shapes.add(new Circle());
		shapes.add(new Triangle());
		shapes.add(new Rectangle());
		IVisitor visitor = new HeightCalculator();
		for (IShape shape : shapes) {
			shape.accept(visitor);
		}
	}

}

interface IVisitor {
	void visit(Circle A);

	void visit(Triangle A);

	void visit(Rectangle A);
}

interface IShape {
	void accept(IVisitor v);
}

class Circle implements IShape {

	@Override
	public void accept(IVisitor v) {
		v.visit(this);

	}

}

class Triangle implements IShape {

	@Override
	public void accept(IVisitor v) {
		v.visit(this);

	}

}

class Rectangle implements IShape {

	@Override
	public void accept(IVisitor v) {
		v.visit(this);

	}

}

/*
 * This method replaces if then else logic as it operates based on object that
 * is visiting it
 */
class HeightCalculator implements IVisitor {

	@Override
	public void visit(Circle A) {
		System.out.println("Calculating height of Circle");

	}

	@Override
	public void visit(Triangle A) {
		System.out.println("Calculating height of Triangle");

	}

	@Override
	public void visit(Rectangle A) {
		System.out.println("Calculating height of Rectangle");

	}

}