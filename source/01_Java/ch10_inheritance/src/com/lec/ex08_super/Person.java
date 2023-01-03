package com.lec.ex08_super;
// this.~ : 내 객체의~
// this() : 내 클래스의 생성자 함수
// super.~ : 부모 클래스의 ~
// super() : 부모 클래스의 생성자 함수
public class Person {
	private String name;
	private String character;
	public Person() {
		super(); //부모클래스의 매개변수 없는 생성자 함수 //super클래스 생성자는 항상 위에 있어야 함
		System.out.println("매개변수 없는 Person 생성자");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 2개짜리 Person 생성자");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public void intro() {
		System.out.println("*" + name+ "은" +character);
	}
}
