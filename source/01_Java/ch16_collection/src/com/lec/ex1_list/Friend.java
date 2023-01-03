package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birth;
	public Friend(String name, String tel, Date birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		// Friend f = new Friend ("È«", "717-7777");
		// sysout(f) => È« 717-7777

		if (birth != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
			return "name=" + name + ", tel=" + tel + ", birth=" + sdf.format(birth);
		}else {
			return "name=" + name + ", tel=" + tel;
		}
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public Date getBirth() {
		return birth;
	}
	
}
