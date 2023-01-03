package com.lec.ex5_car;
// LowGradeCar low = new LowGradeCar("빨강", "일반타이어", "1000", "파워핸들", getSpec())
public class LowGradeCar extends Car {
	private int taxLow = 50000;
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}

	@Override
	public void getSpec() {
		System.out.println("**************");
		System.out.println("색상: " +getColor());
		System.out.println("타이어: " +getTire());
		System.out.println("배기량: " +getDisplacement());
		System.out.println("핸들: " +getHandle());
		if (getDisplacement() > 900) {
			taxLow += (getDisplacement() - 900) * 500;
//			taxLow = taxLow + (getDisplacement()-900) * 500;
		}
		System.out.println("세금: " +taxLow);
		System.out.println("**************");
	}
}
