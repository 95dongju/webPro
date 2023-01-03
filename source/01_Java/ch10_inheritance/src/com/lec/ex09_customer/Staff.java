package com.lec.ex09_customer;

public class Staff extends Person {
	private String hiredate; //입사일 ("2022-12-12")
	private String department; //부서
	// Staff s = new Staff ("홍사원", "010-0000-0000", "2022-12-01", "전산실")

	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}	
	@Override
	public String infoString() {
		return super.infoString() + "\t [부서] " +department+"\t [입사일] " +hiredate;
	}
}
