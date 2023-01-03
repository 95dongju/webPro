package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("가위 (0), 바위(1), 보(2) 중에 하나를 입력하세요: ");
		int you = sc.nextInt();
		int com = ((int)(Math.random()*3));
		
		System.out.println(" ");
		
		switch (you) {
		case 0:
			System.out.println("당신은 가위");break;
		case 1:
			System.out.println("당신은 바위");break;
		case 2:
			System.out.println("당신은 보");break;
		default:
			System.out.println("유효하지 않은 값입니다");
		} // switch you
		
		
		switch (com) {
		case 0:
			System.out.println("컴퓨터는 가위");break;
		case 1:
			System.out.println("컴퓨터는 바위");break;
		case 2:
			System.out.println("컴퓨터는 보");break;
		} // switch com
		
		System.out.println(" ");
		
		if (you == com+1) {
			System.out.println("당신이 졌습니다!");
		}else if (you+1 == com) {
			System.out.println("당신이 이겼습니다!");
		}else if (you == com+2) {
			System.out.println("당신이 이겼습니다!");
		}else if (you+2 == com) {
			System.out.println("당신이 졌습니다!");
		}else if (you == com) {
			System.out.println("같은 것을 내셨네요");
		} // if
		
		sc.close();
	} // main
} // class
