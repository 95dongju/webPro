package com.lec.ex09_customer;

public class Person {
	private String name;
	private String tel; //��ȣ�� ������ String
	//Person p = new Person ("ȫ�浿", "010-0000-0000");
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public String infoString() {
		return "[�̸�]"+name+"\t[��ȭ]" +tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
