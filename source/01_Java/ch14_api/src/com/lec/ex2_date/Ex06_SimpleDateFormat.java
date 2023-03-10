package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	public static void main(String[] args) {
		Date 				nowDate = new Date();
		Calendar 			nowCal = Calendar.getInstance();
		GregorianCalendar 	nowGc = new GregorianCalendar(2022,1,1);
		/* yyyy(년도 4자리) yy(년도 2자리) MM(03) M(3) dd(08) d(8)
		 * E(요일) a(오전/오후) H(24시) h(12시) m(분) s(초)
		 * w (이번 년도 몇번째 주) W (이번 월 몇번째 주) D (올해 몇번째 날) */
		SimpleDateFormat 	sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		System.out.println(sdf.format(nowDate));
		String dateStr = sdf.format(nowDate);
		String calstr = sdf.format(nowCal.getTime()); //getTime: Calendar / gregorian을 Date형으로 변환
		String gcStr = sdf.format(nowGc.getTime());
		System.out.println(dateStr);
		System.out.println(calstr);
		System.out.println(gcStr);
	}
}
