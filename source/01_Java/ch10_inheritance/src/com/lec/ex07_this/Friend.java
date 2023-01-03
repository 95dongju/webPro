package com.lec.ex07_this;
// this.~ : �� ��ü�� ~
// this() : �� Ŭ������ ������ �Լ�
// super.~
// super()
public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this(); // = Friend() �� ȣ���� �Ͱ� ���� // superŬ���� �����ڴ� �׻� ���� �־�� ��
		this.name = name;
		System.out.println("�Ű����� 1�� �ִ� ������ �Լ�");
	}
	public Friend(String name, String tel) {
		this(name); // = Friend(name)
		this.tel = tel;
		System.out.println("�Ű����� 2�� �ִ� ������ �Լ�");
	}
	public String infoString() {
		return name + " : " + tel;
	}
}
