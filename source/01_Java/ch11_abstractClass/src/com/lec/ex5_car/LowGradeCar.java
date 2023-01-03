package com.lec.ex5_car;
// LowGradeCar low = new LowGradeCar("����", "�Ϲ�Ÿ�̾�", "1000", "�Ŀ��ڵ�", getSpec())
public class LowGradeCar extends Car {
	private int taxLow = 50000;
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}

	@Override
	public void getSpec() {
		System.out.println("**************");
		System.out.println("����: " +getColor());
		System.out.println("Ÿ�̾�: " +getTire());
		System.out.println("��ⷮ: " +getDisplacement());
		System.out.println("�ڵ�: " +getHandle());
		if (getDisplacement() > 900) {
			taxLow += (getDisplacement() - 900) * 500;
//			taxLow = taxLow + (getDisplacement()-900) * 500;
		}
		System.out.println("����: " +taxLow);
		System.out.println("**************");
	}
}
