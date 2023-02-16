package com.lec.ex;

public class Student {
	private String noStudent;
	private String sName;
	private int sGrade;
	private char sClass;
	private int score;
	public Student() {}
	public Student(String noStudent, String sName, int sGrade, char sClass, int score) {
		this.noStudent = noStudent;
		this.sName = sName;
		this.sGrade = sGrade;
		this.sClass = sClass;
		this.score = score;
	}
	public String getNoStudent() {
		return noStudent;
	}
	public void setNoStudent(String noStudent) {
		this.noStudent = noStudent;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsGrade() {
		return sGrade;
	}
	public void setsGrade(int sGrade) {
		this.sGrade = sGrade;
	}
	public char getsClass() {
		return sClass;
	}
	public void setsClass(char sClass) {
		this.sClass = sClass;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
