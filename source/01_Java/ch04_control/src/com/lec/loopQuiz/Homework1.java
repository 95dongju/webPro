package com.lec.loopQuiz;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int you, com;
		while(true) {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �Է��ϼ���.");
			you = sc.nextInt();
			if(you==-1) break;
			com = (int)(Math.random()*3);
			String comStr = (com==0) ? "����" : (com==1) ? "����" : "��";
			String youStr = (you==0) ? "����" : (you==1) ? "����" : "��";
			if(you<-1 || you>2) {
				System.out.print("����(0), ����(1), ��(2) �� �ϳ��� �Է��ϼ���.");
			}else {
				if((you+2)%3 == com) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���!\n", youStr, comStr);
				}else if ((you+1)%3 == com) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ��ǻ�Ͱ� �̰���!\n", youStr, comStr);
				}else {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ���� ���� ���̳׿�!\n", youStr, comStr);
				}	
			}
		}sc.close();
		System.out.println("BYE");
	}
}