package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("���� (0), ����(1), ��(2) �߿� �ϳ��� �Է��ϼ���: ");
		int you = sc.nextInt(); // 0, 1, 2 �� �Է�
		
		if(you == 0) {
			System.out.println("����� ����");
		}else if(you == 1) {
			System.out.println("����� ����");
			
		}else if (you == 2) {
			System.out.println("����� ��");
		}else {
			System.out.println("��ȿ���� ���� ���Դϴ�");
		}
		sc.close();
	}
}
