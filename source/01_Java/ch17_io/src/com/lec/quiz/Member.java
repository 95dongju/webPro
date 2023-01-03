package com.lec.quiz;

import java.text.SimpleDateFormat;

public class Member {
	private String name;
	private String tel;
	private String birth;
	private String address;
	
	
	public Member(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	
	@Override
	public String toString() {
		if(birth != null) {
			return name+"\t"+tel+"\t"+birth+"생\t"+address+"\n";
		}
		return name+"\t"+tel+"\t생일모름\t"+address;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
