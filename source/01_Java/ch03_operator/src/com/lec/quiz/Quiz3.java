package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in); 
		System.out.print("ù��° ������ �Է��ϼ��� :");
		int num1 = sc1.nextInt();
		Scanner sc2 = new Scanner(System.in);
		System.out.print("�ι�° ������ �Է��ϼ��� :");
		int num2 = sc2.nextInt();
		String result1 = (num1 == num2) ? "���� �����ϴ�" : "���� �ٸ��ϴ�";
		System.out.println(" ");
		System.out.println("�Է��Ͻ� ��" + num1 + "��(��) " + num2 +"��(��) " + result1);
		System.out.println(" ");
//		System.out.printf("�Է��Ͻ� �� %d��(��) %d ��(��) %s\n", num1, num2, result1);
		String result2 = (num1 > num2) ? "Ů�ϴ�" : "���ų� �۽��ϴ�";
//		System.out.println("ù��°�� �Է��Ͻ� ����" + num1 + "��(��) " +num2 + "���� " +result2);
		System.out.printf("ù��°�� �Է��Ͻ� ���� %d��(��) �ι�°�� �Է��Ͻ� %d���� %s", num1, num2, result2);
		sc1.close();
		sc2.close();

		
	}
}
