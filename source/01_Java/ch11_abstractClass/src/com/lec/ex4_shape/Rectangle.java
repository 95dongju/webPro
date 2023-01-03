package com.lec.ex4_shape;

public class Rectangle extends Shape {
	private int w;
	private int h;
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return w*h;
	}
	
	@Override
	public void draw() {
		System.out.print("»ç°¢Çü ");
		super.draw();
	}
}
