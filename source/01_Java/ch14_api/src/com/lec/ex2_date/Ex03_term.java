package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

// 두 시점 계산 (대출일부터 반납일까지 며칠 지났는지)
// GregorianCalendar 이용해서 두 시점을 저장
public class Ex03_term {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar(); // 현재 시점 저장
		long nowMillis = now.getTimeInMillis(); // 1970.1.1 ~ 현재까지의 밀리세컨
		GregorianCalendar checkOut = new GregorianCalendar(2022, 10, 28, 9, 30); // 대출 시점 특정
		long checkMillis = checkOut.getTimeInMillis(); // 1970.1.1 ~ checkOut까지의 밀리세컨
		//System.out.println("며칠 지났는지? " +(now - checkOut)); // 데이터형은 연산이 되지 않음
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));
		System.out.println("며칠 지났는지? " +day);
		
		Date date = new Date(); // 현재 시점 저장
		Date checkOutDate = new Date(new GregorianCalendar(2022,10,28).getTimeInMillis()); // 특정한 시점
		long dateMillis = date.getTime(); // 1970.1.1 ~ now까지의 밀리세컨
		long checkOutMillis = checkOutDate.getTime();
		int day1 = (int)((dateMillis - checkOutMillis)/(1000*60*60*24));
		System.out.println("며칠 지났는지? " +day1);
		
	}
}
