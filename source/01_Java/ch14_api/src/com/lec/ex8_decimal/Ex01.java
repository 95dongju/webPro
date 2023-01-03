package com.lec.ex8_decimal;

import java.text.DecimalFormat;

public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8787;
		DecimalFormat df = new DecimalFormat("");
		// 패턴에 들어가는 문법: 숫자 자리수에는 #(있으면 출력, 없으면 출력 안함) or 0(반드시 출력)
		DecimalFormat df1 = new DecimalFormat("0000000.00000");
		System.out.println("0000000.00000: " +df1.format(number));
		DecimalFormat df2 = new DecimalFormat("#######.##");
		System.out.println("#######.##: " +df2.format(number));
		DecimalFormat df3 = new DecimalFormat(",###.####");
		System.out.println(",###.####: " +df3.format(number));
		DecimalFormat df4 = new DecimalFormat(",000.00");
		System.out.println("0,000.00: " +df4.format(number));
		DecimalFormat df5 = new DecimalFormat("##.##%");
		System.out.println("##.##%: " +df5.format(0.7845)); // 소수점 2자리 이상은 알아서 반올림
		DecimalFormat df6 = new DecimalFormat("#.####E0"); // E 뒤에는 0만 가능
		System.out.println("#.####E0: " +df6.format(number)); // 10의 6승 타입으로 출력
		
		
	}
}
