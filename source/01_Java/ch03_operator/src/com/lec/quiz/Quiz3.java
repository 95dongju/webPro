package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in); 
		System.out.print("첫번째 정수를 입력하세요 :");
		int num1 = sc1.nextInt();
		Scanner sc2 = new Scanner(System.in);
		System.out.print("두번째 정수를 입력하세요 :");
		int num2 = sc2.nextInt();
		String result1 = (num1 == num2) ? "서로 같습니다" : "서로 다릅니다";
		System.out.println(" ");
		System.out.println("입력하신 수" + num1 + "와(과) " + num2 +"은(는) " + result1);
		System.out.println(" ");
//		System.out.printf("입력하신 수 %d와(과) %d 은(는) %s\n", num1, num2, result1);
		String result2 = (num1 > num2) ? "큽니다" : "같거나 작습니다";
//		System.out.println("첫번째로 입력하신 정수" + num1 + "은(는) " +num2 + "보다 " +result2);
		System.out.printf("첫번째로 입력하신 정수 %d은(는) 두번째로 입력하신 %d보다 %s", num1, num2, result2);
		sc1.close();
		sc2.close();

		
	}
}
