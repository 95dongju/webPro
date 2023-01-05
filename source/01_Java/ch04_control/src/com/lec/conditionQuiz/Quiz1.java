package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz1 {
		public static void main(String[] args) {
			Scanner sc = new Scanner (System.in);
			System.out.print("숫자를 입력하세요: ");
			int num1 = sc.nextInt();
			if (num1<0) {
				System.out.println(num1 + "의 절대값은 " +num1*-1 + "입니다");
			}else if(num1>0) {
				System.out.println(num1 + "의 절대값은 " + num1 + "입니다");
			}else {
				System.out.println("유효하지 않은 값을 입력하셨습니다");
		}
		sc.close();
	}
}
