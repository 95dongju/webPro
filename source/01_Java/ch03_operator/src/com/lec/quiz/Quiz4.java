package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int num1 = sc.nextInt();
		String result = (num1 >= 65) ? "65세 이상이므로 경로우대 대상입니다." : "65세 미만이므로 일반 대상입니다.";
		System.out.println("당신은 " + result);
		sc.close();
	}
}
