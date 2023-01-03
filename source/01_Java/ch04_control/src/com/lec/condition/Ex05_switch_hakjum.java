package com.lec.condition;

import java.util.Scanner;

public class Ex05_switch_hakjum {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		int temp = (score==100) ? score-1 : score; // score/10으로 나누면 101~109 입력시 a학점이 나옴. 그렇기 때문에 temp(임시)만들어서 100 이상이 되는Ex04_if_hakjum.java
		switch(temp/10) {
		case 9:
			System.out.println("A학점");break;
		case 8:
			System.out.println("B학점");break;
		case 7:
			System.out.println("C학점");break;
		case 6:
			System.out.println("D학점");break;
		case 5: case 4: case 3: case 2: case 1:
			System.out.println("F학점");break;
		default:
			System.out.println("유효하지 않는 점수입니다");
		}
		sc.close();
	}
}

