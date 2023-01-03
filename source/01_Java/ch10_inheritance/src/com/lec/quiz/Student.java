package com.lec.quiz;

public class Student extends Person {
	private String ban;
	public static int countStu = 1; // 공유변수
	
	public Student(String id, String name, String ban) {
		super(id,name);
		this.ban = ban;
		setNo("student"+countStu);
		countStu++;
	}

	@Override
	public String infoString() {
		return super.infoString() + "\t(반)" + ban;
	}
	
//	public void print() {
//	super.print();
//	System.out.println("~~");
	
	public static void setCount(int count) {
		Student.countStu = count;
	}

}
