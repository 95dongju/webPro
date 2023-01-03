package com.lec.ex2_parking;

public class ParkingMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111·ç 1111", 12);
		System.out.print(car1.infoStringIn());
		car1.out(14);
		System.out.println(car1.infoStringOut());
		
	}
}
