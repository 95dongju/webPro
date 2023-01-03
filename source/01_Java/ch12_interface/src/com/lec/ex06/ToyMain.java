package com.lec.ex06;

public class ToyMain {
	public static void main(String[] args) {
		PoohToy pooh = new PoohToy();
		MazinggerToy mazingger = new MazinggerToy();
		AirplaneToy airplane = new AirplaneToy();
		IToy pooh1 = new PoohToy();
//		MazinggerToy mazingger1 = new IToy();
//		
//		pooh1.canMoveArmLeg();
		pooh.canMoveArmLeg();
		
		IToy[] toy = {pooh, mazingger, airplane};
		for(IToy t : toy) {
			System.out.println(t.getClass().getName()); // getClass() = equals랑 똑같음. 객체의 클래스 이름 출력
		}
		
	}
}
