package com.lec.ex2;

public class TestMain {
	public static void main(String[] args) {
//		SuperClass super = new SuperClass; // 객체는 만들 수 없음
//		SuperClass obj; // 변수는 만들 수 있음
		SuperClass obj2 = new ChildClass(); // 타입으로만 가능
		obj2.method1();
		obj2.method2();
		obj2.method3();
		
// 잘못된 예시
		SuperClass nope = new SuperClass() {
			public void method1() {
				System.out.println("익명클래스의 method1");
			}
		};
		obj2.method1();
		nope.method1();
		nope.method2();
		nope.method3(); // 이름 없는 클래스임. 안드로이드에서는 가능하지만, 자바에서는 안됨.
	}
}
