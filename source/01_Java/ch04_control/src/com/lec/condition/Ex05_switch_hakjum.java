package com.lec.condition;

import java.util.Scanner;

public class Ex05_switch_hakjum {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("������ �Է��ϼ���: ");
		int score = sc.nextInt();
		int temp = (score==100) ? score-1 : score; // score/10���� ������ 101~109 �Է½� a������ ����. �׷��� ������ temp(�ӽ�)���� 100 �̻��� �Ǵ�Ex04_if_hakjum.java
		switch(temp/10) {
		case 9:
			System.out.println("A����");break;
		case 8:
			System.out.println("B����");break;
		case 7:
			System.out.println("C����");break;
		case 6:
			System.out.println("D����");break;
		case 5: case 4: case 3: case 2: case 1:
			System.out.println("F����");break;
		default:
			System.out.println("��ȿ���� �ʴ� �����Դϴ�");
		}
		sc.close();
	}
}

