package com.lec.ex4_shape;

import com.lec.cons.Constant;

public class Circle extends Shape {
	private int r;
	
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(int r) {
		super();
		this.r = r;
	}

	@Override
	public double area() {
		return Constant.PI*r*r;
	}
	@Override
	public void draw() {
		System.out.print("¿ø ");
		super.draw();
	}
}
