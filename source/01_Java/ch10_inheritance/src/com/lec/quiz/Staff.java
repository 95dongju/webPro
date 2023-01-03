package com.lec.quiz;

public class Staff extends Person {
	private String department;
	public static int countStf = 1;
	
	public Staff(String id, String name, String department) {
		super(id,name);
		this.department = department;
		setNo("staff"+countStf);
		countStf++;
	}

	@Override
	public String infoString() {
		return super.infoString() + "\t(ºÎ¼­)" + department;
	}
	
	public static void setCount(int count) {
		Staff.countStf = count;
	}

	
}
