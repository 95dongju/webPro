package com.lec.ex07_this;
// this.~ : 내 객체의 ~
// this() : 현 클래스의 생성자 함수
// super.~
// super()
public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this(); // = Friend() 를 호출한 것과 같음 // super클래스 생성자는 항상 위에 있어야 함
		this.name = name;
		System.out.println("매개변수 1개 있는 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name); // = Friend(name)
		this.tel = tel;
		System.out.println("매개변수 2개 있는 생성자 함수");
	}
	public String infoString() {
		return name + " : " + tel;
	}
}
