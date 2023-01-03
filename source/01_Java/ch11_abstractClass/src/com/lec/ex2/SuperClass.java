package com.lec.ex2;
// method1(추상메소드) / method2, method3(일반메소드)
public abstract class SuperClass { 
	public abstract void method1(); // 추상메소드가 있으면 반드시 추상클래스여야 함  ..
	public void method2() {
		System.out.println("SuperClass의 method2 (일반메소드)");
	}
	public void method3() {
		System.out.println("SuperClass의 method3");
	}
}
