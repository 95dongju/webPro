package com.lec.ex08_super;

public class Baby extends Person {
	public Baby() {
		super(); // == Person()
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); // 매개변수 없는 생성자 말고, 매개변수 있는 생성자만 호출할 수 있음 == Person(name, character); 맨 윗줄에 써야함
//		setName(name);
//		setCharacter(character);
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.print("& 이쁜 아기 ");
		super.intro(); //부모클래스의 intro()
	}
}
