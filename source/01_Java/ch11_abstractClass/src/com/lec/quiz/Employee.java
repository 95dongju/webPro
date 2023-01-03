package com.lec.quiz;

public abstract class Employee {
	private String name;
	private int computePay;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public abstract int computePay();
	
	public final int computeIncentive() {
		if (computePay() > 3000000) {
			return (int)(computePay() * 0.05);
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
