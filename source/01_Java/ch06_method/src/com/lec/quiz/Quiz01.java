package com.lec.quiz;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int you;
		do {
			System.out.println("2���� 9������ ���ڸ� �Է��ϼ���: ");
			you = sc.nextInt();
		}while(you<2 || you>9);
		gugudan(you);
//		System.out.printf("%d * %d = %d\t", you);
	} // main
	private static void gugudan (int value) {
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("%d * %d = %d\t", value, i, value*i);
		}
	}
}
