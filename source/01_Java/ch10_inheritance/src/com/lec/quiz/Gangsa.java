package com.lec.quiz;

public class Gangsa extends Person {
	private String subject;
	public static int countLec = 1;
	
	public Gangsa(String id, String name, String subject) {
		super(id,name);
		this.subject = subject;
		setNo("lecturer"+countLec);
		countLec++;
	}

	@Override
	public String infoString() {
		return super.infoString() + "\t(°ú¸ñ)" + subject;
	}
	
	public static void setCount(int count) {
		Gangsa.countLec = count;
	}

	
}
