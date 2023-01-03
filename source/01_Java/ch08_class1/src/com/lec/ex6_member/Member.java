package com.lec.ex6_member;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	
	public Member() {}
	
	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	 
	public String infoString() {
		
		String gen = "이름 : "+name;
		gen += "\n아이디 : " +id;
		gen += "\n이메일 : " +email;
		gen += "\n주소 : " +address;
		gen += "\n생일 : " +birth;
		gen += "\n성별 : "+(gender=='m'?"남자":(gender=='f'?"여자":"무")); 
		return gen;
		
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getBirth() {
		return birth;
	}

	public char getGender() {
		return gender;
	}
	
	
	
	
}
