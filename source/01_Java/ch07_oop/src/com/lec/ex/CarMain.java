package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); //new로 만들면 값이 0으로 초기화되어있음.
		//myPorsche.color = "빨강색";
		myPorsche.setColor("빨강");
		System.out.println(myPorsche.getColor()+"차량 배기량: " + myPorsche.getCc());
		myPorsche.drive();
		System.out.println(myPorsche.getColor()+"차량 속도: " + myPorsche.getSpeed());
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		//yourPorsche.color = "파란색";
		yourPorsche.setColor("파랑");
		yourPorsche.drive();
		System.out.println("내 차 속도는 "+myPorsche.getSpeed());
	}
}
