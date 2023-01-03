package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = sc.nextInt();
		System.out.println((num%2==0 ? "입력하신 수는 짝수입니다" : "입력하신 수는 홀수입니다"));
		sc.close();
}
}
