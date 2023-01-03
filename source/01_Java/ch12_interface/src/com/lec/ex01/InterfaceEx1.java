package com.lec.ex01;
// static final 변수(상수)와 추상 메소드만 올 수 있음 
public interface InterfaceEx1 {
	
//	public static final int CONSTANT_NUM = 10;
	public int CONSTANT_NUM = 10; // 인터페이스 내에서는 변수가 오면 무조건 상수이기 때문에 static final 생략 가능
	
//	public abstract void method1();
	public void method1(); // interface 내에서는 abstract 생략해도 추상메소드로 사용됨
	
/*	
  	public void method2() {
		System.out.println(""); // 일반 메소드는 쓸수가 없음
	} 
*/	
	
}
