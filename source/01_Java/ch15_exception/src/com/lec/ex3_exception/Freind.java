package com.lec.ex3_exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Freind {
	private String name;
	private String tel;
	private Date birthday;
	public Freind(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Freind(String name, String tel, Date birthday) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		if (birthday != null) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름: " + name + ", 전화번호: " + tel + ", 생일:" + sdf.format(birthday);
		}
		return "이름: " + name + ", 전화번호: " + tel;		
	}	
}
