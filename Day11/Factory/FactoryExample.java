package com.java.Factory;

public class FactoryExample {

	public static void main(String[] args) {
		Shape s = ShapeMethod.getShapeMethod("circle");
		s.draw();
		
		Shape s1 = ShapeMethod.getShapeMethod("square");
		s1.draw();
		
		Shape s2 = ShapeMethod.getShapeMethod("rectangle");
		s2.draw();

	}

}

interface Shape {
	void draw();
}


class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle");
		
	}
	
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square");
	}
	
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle");
		
	}
	
}

class ShapeMethod {
	public static Shape getShapeMethod(String ShapeType) {
		if(ShapeType != null) {
			switch (ShapeType.toLowerCase()) {
			case "circle": 
				return new Circle();
			case "square":
				return new Square();
			case "rectangle":
				return new Rectangle();
			default:
				throw new IllegalArgumentException("Unexpected value: " + ShapeType);
			}
		}
		return null;
	}
}








