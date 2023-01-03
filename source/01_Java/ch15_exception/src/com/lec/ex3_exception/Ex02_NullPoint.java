package com.lec.ex3_exception;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02_NullPoint {
	public static void main(String[] args) {
		Freind hong = new Freind("È«±æµ¿", "010-9999-9999", 
				new Date(new GregorianCalendar(1998,0,1).getTimeInMillis()));
		System.out.println(hong);
		Freind kim = new Freind("±è±æµ¿", "010-8888-8888");
		System.out.println(kim);
	}
}
