package com.lec.ex5_car;

public abstract class Car {
	private String Color;
	private String tire;
	private int displacement;
	private String handle;
	public Car(String color, String tire, int displacement, String handle) {
		super();
		Color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	public abstract void getSpec();
	
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getTire() {
		return tire;
	}
	public void setTire(String tire) {
		this.tire = tire;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
}
