package com.lec.ex01;

public class TestMain {	
	public static void main(String[] args) {
		InterfaceClass obj = new InterfaceClass();
		obj.method1();
		System.out.println(obj.method2());
		InterfaceEx1 obj1 = new InterfaceClass(); // interfaceClass 를 구현 받은 InterfaceEx1, Ex2
		obj1.method1();
//		obj1.method2();
		InterfaceEx2 obj2 = new InterfaceClass();
		obj2.method2();
		System.out.println("상수 CONSTANT_NUM : " +InterfaceEx1.CONSTANT_NUM);
		System.out.println("상수 CONSTANT_NUM : " +InterfaceClass.CONSTANT_NUM);
		System.out.println("상수 CONSTANT_NUM : " +obj.CONSTANT_NUM); // static은 class로 접근 추천, 객체 변수 이름으로 접근 가능하지만 비추
		System.out.println("상수 CONSTANT_STRING : " +InterfaceEx2.CONSTANT_STRING);
		System.out.println("상수 CONSTANT_STRING : " +obj.CONSTANT_STRING);
	}
}
		
		
//		InterfaceClass obj1 = new InterfaceClass(); //
//		InterfaceEx1 ex1 = new InterfaceEx1();
//		InterfaceEx2 ex2 = new InterfaceEx2() {
//			@Override
//			public String method2() {
//				System.out.println("익명클래스의 method2"); // 안드로이드에서는 자주 하지만 자바에서는 익명클래스 만들지 않음. 어나니머스 객체 만들지 않음
//				return null;
//			}
//		};
//		ex2.method2();
			