package com.lec.quiz;

public class SalaryEmployee extends Employee {
	private int annualSalary;
	private int computePay;
	private int computeIncentive;

	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annualSalary = annalSalary;
	}
	
	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return computePay = (annualSalary / 14);
	}
}

