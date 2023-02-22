package com.lec.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Dto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private String pw;
	private int readcount;
	private String ip;
	private Timestamp rdate;
	public Dto() {}
	public Dto(int num, String writer, String subject, String content, String email, String pw, int readcount,
			String ip, Timestamp rdate) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.pw = pw;
		this.readcount = readcount;
		this.ip = ip;
		this.rdate = rdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "Dto [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content + ", email="
				+ email + ", pw=" + pw + ", readcount=" + readcount + ", ip=" + ip + ", rdate=" + rdate + "]";
	}
}
