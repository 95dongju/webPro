package com.lec.conditionQuiz;

import java.time.LocalDate;
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("���� �Է��ϼ���: ");
		int month = sc.nextInt();
		
		
		switch (month) {
			case 3: case 4: case 5:
				System.out.printf("%d���� ���Դϴ�\n", month);break;
			case 6: case 7: case 8:
				System.out.printf("%d���� �����Դϴ�\n", month);break;
			case 9: case 10: case 11:
				System.out.printf("%d���� �����Դϴ�\n", month);break;
			case 12: case 1: case 2:
				System.out.printf("%d���� �ܿ��Դϴ�\n", month);break;
			default:
				System.out.println("��ȿ���� ���� ���� �Է��ϼ̽��ϴ�");	
		}
		System.out.println(" ");
		LocalDate now = LocalDate.now();
		int monthValue = now.getMonthValue();
		System.out.println("������ " + monthValue + "���̸�,");
		
		if (monthValue == 12 && monthValue <= 2) {
			System.out.println("���� ������ �ܿ��Դϴ�");
		}else if (monthValue > 2 && monthValue <= 5) {
			System.out.println("���� ������ ���Դϴ�"); 
		}else if (monthValue > 5 && monthValue <= 8) {
			System.out.println("���� ������ �����Դϴ�");
		}else if (monthValue > 8 && monthValue <= 11) {
			System.out.println("���� ������ �����Դϴ�");			
			
		}
		
	}
}
