package com.lec.loop;

import java.util.Scanner;

public class Ex12doWhile_lotto2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int lotto, su;
		lotto = (int)(Math.random()*45)+1;
		do {
			System.out.print("�ζ� ��ȣ�� ���� ������ : ");
			su = sc.nextInt();
			if (su>lotto) {
				System.out.println(su+"���� ���� ���� �����ϼ���");
			}else if (su<lotto) {
				System.out.println(su+"���� ū ���� �����ϼ���");
			}
		}while(su!=lotto);
		System.out.printf("�����մϴ�! �ζ� ��ȣ�� %d �Դϴ�!\n", lotto);
	}
}

