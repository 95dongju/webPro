package com.lec.ex3_accesstest;

public class AccessTest {
	private int privateMember;	// 같은 클래스 내에서만 사용 가능 --> 외부에서 사용하려면 게터 & 세터
	protected int protectedMember; // 같은 패키지나 상속 받은 클래스에서 사용 가능
	int defaultMember; // default (접근제한) 같은 패키지 내에서만 사용 가능
	public int publicMember; // 아무데서나 사용 가능
	private void privateMethod() {
		System.out.println("private 메소드 - 외부에서 access 불가능, 이 클래스에서만 사용 가능 (getter&setter 필요)");
	}
	protected void protectedMethod() {
		System.out.println("protected 메소드 - 같은 패키지나 상속받은 클래스에서 사용 가능");
	}
	void defaultMethod() {
		System.out.println("default 메소드");
	}
	public void publicMethod() {
		System.out.println("public 메소드");
	}
}
