package com.lec.ex;
// bean 태그 사용하기 위해서는 매개변수 없는 생성자, setter, getter 필수
public class Person {
	private String name;
	private int age;
	private char gender; // 남자:m, 여자:f
	private String address;
	public Person() {} // 매개변수 없는 생성자 함수 반드시 만들어야 함
	public Person(String name, int age, char gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
