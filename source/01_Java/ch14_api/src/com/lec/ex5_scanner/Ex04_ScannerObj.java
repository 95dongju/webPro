package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex04_ScannerObj {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("�̸���? ");
		String name = scMain.nextLine();
		System.out.println("�Է��� �̸��� " +name);

		getNickName(scMain); // scanner ��ü�� getNickName���� ����
		
		System.out.println("���̴�? ");
		int age = scMain.nextInt();
		System.out.println("�Է��� ���̴� " +age);
		scMain.close();
		
	}

	private static void getNickName(Scanner scMain) { // ���� Ÿ���� �� ������� ��
		System.out.print("������? ");
		String nickName = scMain.next();
		System.out.println("�Է��� ������  " +nickName);
	}
}
