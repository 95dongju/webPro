package com.lec.loop;

import java.util.Scanner;

public class Ex11doWhile_lotto1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int lotto, su;
		lotto = (int)(Math.random()*45)+1; //����ȯ �ϱ� ���ؼ��� �ݵ�� ��ȣ�� ����� ��
		System.out.printf("�ζ� ��ȣ�� %d���Դϴ�\n", lotto);
	}
}

