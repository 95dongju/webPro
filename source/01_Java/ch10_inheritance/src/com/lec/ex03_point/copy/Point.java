package com.lec.ex03_point.copy;
// 2차원 좌표
public class Point {
	private int x;
	private int y;
	
	public Point() {
		System.out.println("매개변수 없는 point(부모클래스=super클래스=상위클래스)");
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("매개변수 있는 point");
	}
	public String infoPrint() {
		return "좌표 : x =" + x + ", y = " + y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
