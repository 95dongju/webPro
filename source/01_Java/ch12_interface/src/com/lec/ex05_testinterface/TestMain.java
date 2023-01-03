package com.lec.ex05_testinterface;

public class TestMain {
	public static void main(String[] args) {
		TestChildClass obj = new TestChildClass();
		System.out.println(obj.i1); // static 변수는 클래스 이름으로 접근해야 함, 변수명으로 하면 warning 뜸
		System.out.println(TestChildClass.i1);
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m11();
		TestClass obj1 = obj;
		obj1.m1();
//		obj1.i1(); // testclass에 선언된 i가 아니기 때문에 에러
		
	}
}
