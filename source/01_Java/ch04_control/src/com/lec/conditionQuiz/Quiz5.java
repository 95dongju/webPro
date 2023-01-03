package com.lec.conditionQuiz;

import java.time.LocalDate;
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("월을 입력하세요: ");
		int month = sc.nextInt();
		
		
		switch (month) {
			case 3: case 4: case 5:
				System.out.printf("%d월은 봄입니다\n", month);break;
			case 6: case 7: case 8:
				System.out.printf("%d월은 여름입니다\n", month);break;
			case 9: case 10: case 11:
				System.out.printf("%d월은 가을입니다\n", month);break;
			case 12: case 1: case 2:
				System.out.printf("%d월은 겨울입니다\n", month);break;
			default:
				System.out.println("유효하지 않은 값을 입력하셨습니다");	
		}
		System.out.println(" ");
		LocalDate now = LocalDate.now();
		int monthValue = now.getMonthValue();
		System.out.println("지금은 " + monthValue + "월이며,");
		
		if (monthValue == 12 && monthValue <= 2) {
			System.out.println("현재 계절은 겨울입니다");
		}else if (monthValue > 2 && monthValue <= 5) {
			System.out.println("현재 계절은 봄입니다"); 
		}else if (monthValue > 5 && monthValue <= 8) {
			System.out.println("현재 계절은 여름입니다");
		}else if (monthValue > 8 && monthValue <= 11) {
			System.out.println("현재 계절은 가을입니다");			
			
		}
		
	}
}
