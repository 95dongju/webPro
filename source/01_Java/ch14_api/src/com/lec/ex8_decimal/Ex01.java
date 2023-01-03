package com.lec.ex8_decimal;

import java.text.DecimalFormat;

public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8787;
		DecimalFormat df = new DecimalFormat("");
		// ���Ͽ� ���� ����: ���� �ڸ������� #(������ ���, ������ ��� ����) or 0(�ݵ�� ���)
		DecimalFormat df1 = new DecimalFormat("0000000.00000");
		System.out.println("0000000.00000: " +df1.format(number));
		DecimalFormat df2 = new DecimalFormat("#######.##");
		System.out.println("#######.##: " +df2.format(number));
		DecimalFormat df3 = new DecimalFormat(",###.####");
		System.out.println(",###.####: " +df3.format(number));
		DecimalFormat df4 = new DecimalFormat(",000.00");
		System.out.println("0,000.00: " +df4.format(number));
		DecimalFormat df5 = new DecimalFormat("##.##%");
		System.out.println("##.##%: " +df5.format(0.7845)); // �Ҽ��� 2�ڸ� �̻��� �˾Ƽ� �ݿø�
		DecimalFormat df6 = new DecimalFormat("#.####E0"); // E �ڿ��� 0�� ����
		System.out.println("#.####E0: " +df6.format(number)); // 10�� 6�� Ÿ������ ���
		
		
	}
}
