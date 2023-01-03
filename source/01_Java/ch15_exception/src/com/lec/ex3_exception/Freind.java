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
		return "�̸�: " + name + ", ��ȭ��ȣ: " + tel + ", ����:" + sdf.format(birthday);
		}
		return "�̸�: " + name + ", ��ȭ��ȣ: " + tel;		
	}	
}
