package com.lec.loop;

import java.util.Scanner;

public class Ex13doWhile_lotto3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int lotto, su;
		int min=1, max=45;
		lotto = (int)(Math.random()*45)+1;
		do {
			System.out.printf("%d���� %d���� �ζ� ��ȣ�� ���� ������ : \n", min, max);
			su = sc.nextInt();
			if(su<min || su>max) {
				System.out.println("������ Ȯ���ϼ���.");
			}else if (su>lotto) {
				max = su-1;
				//System.out.println(su+"���� ���� ���� �����ϼ���");
			}else if (su<lotto) {
				min = su+1;
				//System.out.println(su+"���� ū ���� �����ϼ���");
			}
		}while(su!=lotto);
		System.out.printf("�����մϴ�! �ζ� ��ȣ�� %d �Դϴ�!\n", lotto);
	}
}

