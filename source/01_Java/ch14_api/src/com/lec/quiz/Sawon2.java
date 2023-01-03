package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {
	public static final String COM = "COMPUTER";
	public static final String PLA = "PLANNING";
	public static final String DES = "DESIGN";
	public static final String ACC = "ACCOUNTING";
	public static final String HUM = "HUMANRESOURCES";
	
	private String number;
	private String name;
	private Dept part;
	private Date date;

	
	public Sawon2(String number, String name, Dept part) {
		this.number = number;
		this.name = name;
		this.part = part;
		date = new Date();
	}
	
	public Sawon2(String number, String name, Dept part, int year, int month, int day) {
		this.number = number;
		this.name = name;
		this.part = part;
		date = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		if((part+"").length()>8) 
			return "[���]" +number+ "\t[�̸�]" +name+ "\t[�μ�]" +part+ "\t\t[�Ի���]" +sdf.format(date);
		else
			return "[���]" +number+ "\t[�̸�]" +name+ "\t[�μ�]" +part+ "\t\t[�Ի���]" +sdf.format(date);
	}

	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public Dept getPart() {
		return part;
	}
	public Date getDate() {
		return date;
	}
}
