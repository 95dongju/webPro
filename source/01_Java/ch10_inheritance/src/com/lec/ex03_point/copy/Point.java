package com.lec.ex03_point.copy;
// 2���� ��ǥ
public class Point {
	private int x;
	private int y;
	
	public Point() {
		System.out.println("�Ű����� ���� point(�θ�Ŭ����=superŬ����=����Ŭ����)");
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("�Ű����� �ִ� point");
	}
	public String infoPrint() {
		return "��ǥ : x =" + x + ", y = " + y;
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
