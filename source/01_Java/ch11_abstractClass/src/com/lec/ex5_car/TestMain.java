package com.lec.ex5_car;

public class TestMain {
	public static void main(String[] args) {
		Car lowCar = new LowGradeCar(CarSpec.COLOR_GRAY, CarSpec.TIRE_NORMAL, 
				CarSpec.DISPLACEMENT_1000, CarSpec.HANDLE_POWER);
		
		Car highCar = new HighGradeCar(CarSpec.COLOR_WHITE, CarSpec.TIRE_WIDE, 
				CarSpec.DISPLACEMENT_2000, CarSpec.HANDLE_POWER);
		lowCar.getSpec();
		highCar.getSpec();
	}
}
