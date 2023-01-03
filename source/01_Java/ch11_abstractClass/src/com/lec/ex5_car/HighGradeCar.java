package com.lec.ex5_car;

public class HighGradeCar extends Car {
	private int taxHigh = 100000;
	
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}
	
	@Override
	public void getSpec() {
		System.out.println("**************");
		System.out.println("����: " +getColor());
		System.out.println("Ÿ�̾�: " +getTire());
		System.out.println("��ⷮ: " +getDisplacement());
		System.out.println("�ڵ�: " +getHandle());
		if (getDisplacement() > 1500) {
			taxHigh += (getDisplacement() - 1500) * 600;
		}
		System.out.println("����: " +taxHigh);
		System.out.println("**************");
	}
}
