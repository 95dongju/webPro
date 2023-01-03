package com.lec.ex4_object;

public class Friend {
	private String name;
	private String tel;
	private String birth;
	private String address;
	public Friend() {}
	public Friend(String name, String tel, String birth, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() { //infoString이나 infoPrint와 다르게 무조건 출력하게 하는 것
		// TODO Auto-generated method stub
		return "[이름]" +name+ "\t[전화]" +tel+ "\t[생일]" +birth+ "\t[주소]" +address;
	}

	public String getBirth() {
		return birth;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
}
