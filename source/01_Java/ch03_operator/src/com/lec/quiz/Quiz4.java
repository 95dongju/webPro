package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		String result = (num1 >= 65) ? "65�� �̻��̹Ƿ� ��ο�� ����Դϴ�." : "65�� �̸��̹Ƿ� �Ϲ� ����Դϴ�.";
		System.out.println("����� " + result);
		sc.close();
	}
}
