package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("���� (0), ����(1), ��(2) �߿� �ϳ��� �Է��ϼ���: ");
		int you = sc.nextInt();
		int com = ((int)(Math.random()*3));
		
		System.out.println(" ");
		
		switch (you) {
		case 0:
			System.out.println("����� ����");break;
		case 1:
			System.out.println("����� ����");break;
		case 2:
			System.out.println("����� ��");break;
		default:
			System.out.println("��ȿ���� ���� ���Դϴ�");
		} // switch you
		
		
		switch (com) {
		case 0:
			System.out.println("��ǻ�ʹ� ����");break;
		case 1:
			System.out.println("��ǻ�ʹ� ����");break;
		case 2:
			System.out.println("��ǻ�ʹ� ��");break;
		} // switch com
		
		System.out.println(" ");
		
		if (you == com+1) {
			System.out.println("����� �����ϴ�!");
		}else if (you+1 == com) {
			System.out.println("����� �̰���ϴ�!");
		}else if (you == com+2) {
			System.out.println("����� �̰���ϴ�!");
		}else if (you+2 == com) {
			System.out.println("����� �����ϴ�!");
		}else if (you == com) {
			System.out.println("���� ���� ���̳׿�");
		} // if
		
		sc.close();
	} // main
} // class
