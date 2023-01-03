package com.lec.quiz;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {
	public static void main(String[] args) {
		Book book = new Book("890§°-01", "java", "»´±Êµø");
		Book book1 = new Book("890§°-02", "hadoop", "»´«œµ”");
		try {
			book.checkOut("kim");
			book1.checkOut("lee");
			book.checkOutDate(new Date(new GregorianCalendar(2020, 10, 30).getTimeInMillis())); //¥Î√‚¿œ ¡∂¿€
			book.checkIn();
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}//try
		System.out.println(book);
		System.out.println(book1);
	}//main
}