package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz1 {
		public static void main(String[] args) {
			Scanner sc = new Scanner (System.in);
			System.out.print("���ڸ� �Է��ϼ���: ");
			int num1 = sc.nextInt();
			if (num1<0) {
				System.out.println(num1 + "�� ���밪�� " +num1*-1 + "�Դϴ�");
			}else if(num1>0) {
				System.out.println(num1 + "�� ���밪�� " + num1 + "�Դϴ�");
			}else {
				System.out.println("��ȿ���� ���� ���� �Է��ϼ̽��ϴ�");
		}
		sc.close();
	}
}
