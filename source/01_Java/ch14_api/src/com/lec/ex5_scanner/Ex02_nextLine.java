package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�ּҴ� : ");
//		scan.nextLine(); // ���۰� ������� ���� ���۸� ����� �ȵ�. �׷��� ���ۿ� ���� ������ ���� ��µ��� ����
		String address = scan.nextLine();
		System.out.println("�Է� �ּҴ� " +address);
		System.out.println("����: ");
		int age = scan.nextInt();
		System.out.println("���̴� " +age);
		System.out.println("�̸�: ");
		// ���̸� nextInt�� �޾ұ� ������ ���ۿ� "\n"�� �ִ� ����
		scan.nextLine(); // ���� ����� ����
		String name = scan.nextLine();
		System.out.println("�̸��� " +name);
		System.out.println("���α׷� ��");
	}
}
