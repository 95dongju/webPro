package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=0 ; i<11 ; i++) {
			tot += i;
		}
		String result = (tot%2 == 0) ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		System.out.printf("1���� 10������ ���� %d�̸�, %s\n", tot, result);
		// ----------------------------------------------------------
		tot = 0;
		for(int i=10 ; i<101 ; i++) {
			tot += i;
		}
		result = (tot%2 == 0) ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		System.out.printf("10���� 100������ ���� %d�̸�, %s\n", tot, result);
		// �ڵ带 �����ؾ� �ϴ� ���� ���� ��, �ڵ带 �����ϰų� ���� �ڵ����� �ʰ� �޼ҵ带 �̿���
	}
}
