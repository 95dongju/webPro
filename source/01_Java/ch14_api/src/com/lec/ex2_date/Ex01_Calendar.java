package com.lec.ex2_date;

import java.util.Calendar;

public class Ex01_Calendar {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance(); // Calendar �� �̱����̱� ������ Calendar.���� �����, ������ protected
		// Calendar�� �ý��� ���� �ð��� ������ ��
		System.out.println(now);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		System.out.println(month);
		int day = now.get(Calendar.DAY_OF_MONTH)+1; // �ý����� 0������ �����ϱ� ������ �ݵ�� +1�� ����� ��
		int week = now.get(Calendar.DAY_OF_WEEK); // 1:��, 2:��, 3:ȭ, 4:��, 5:�� ...
		System.out.println(week);
		int hour24 = now.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour24);
		int hour = now.get(Calendar.HOUR);
		System.out.println(hour);
		int ampm = now.get(Calendar.AM_PM); // 0�� am, 1�� pm
		System.out.println(ampm);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millisec = now.get(Calendar.MILLISECOND);
		System.out.printf("%d�� %d�� %d��", year, month, day);
		switch (week) {
			case 1: System.out.print("�Ͽ���"); break;
			case 2: System.out.print("������"); break;
			case 3: System.out.print("ȭ����"); break;
			case 4: System.out.print("������"); break;
			case 5: System.out.print("�����"); break;
			case 6: System.out.print("�ݿ���"); break;
			case 7: System.out.print("�����"); break;
		}
		System.out.printf("%d�� %d�� %d�� %d (%s %d�� %d�� %d��)\n", 
				hour24, minute, second, millisec,(ampm==0 ? "����":"����"),hour, minute, second);
		// %d (����)
		// %tY(��) %tm(��), %td(��), %ta(����), %tH(24��), %tp(����/����), %tl(12��), %tM(��) %tS(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tH�� %tM�� %tS�� (%tp %tl��)\n",now,now,now,now,now,now,now,now,now);
		
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tH�� %1$tM�� %1$tS�� (%1$tp %1$tl��)\n", now);
	}
}
