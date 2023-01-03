package com.lec.ex2;
// method1(추상), method2, method3 상속 받음
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("Child Class의 method1 - 추상메소드라서 오버라이드함");
	}
	@Override
	public void method2() {
		System.out.println("걍 오버라이드 함 Child Class method2");
	}

}
