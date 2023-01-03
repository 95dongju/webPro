package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

// �� ���� ��� (�����Ϻ��� �ݳ��ϱ��� ��ĥ ��������)
// GregorianCalendar �̿��ؼ� �� ������ ����
public class Ex03_term {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar(); // ���� ���� ����
		long nowMillis = now.getTimeInMillis(); // 1970.1.1 ~ ��������� �и�����
		GregorianCalendar checkOut = new GregorianCalendar(2022, 10, 28, 9, 30); // ���� ���� Ư��
		long checkMillis = checkOut.getTimeInMillis(); // 1970.1.1 ~ checkOut������ �и�����
		//System.out.println("��ĥ ��������? " +(now - checkOut)); // ���������� ������ ���� ����
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));
		System.out.println("��ĥ ��������? " +day);
		
		Date date = new Date(); // ���� ���� ����
		Date checkOutDate = new Date(new GregorianCalendar(2022,10,28).getTimeInMillis()); // Ư���� ����
		long dateMillis = date.getTime(); // 1970.1.1 ~ now������ �и�����
		long checkOutMillis = checkOutDate.getTime();
		int day1 = (int)((dateMillis - checkOutMillis)/(1000*60*60*24));
		System.out.println("��ĥ ��������? " +day1);
		
	}
}
