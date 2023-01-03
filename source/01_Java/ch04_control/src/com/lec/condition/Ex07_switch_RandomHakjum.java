package com.lec.condition;

import java.util.Scanner;
//실행할때마다 컴퓨터가 난수점수 (랜덤스코어) 발생하여 학점 출력
public class Ex07_switch_RandomHakjum {
	public static void main(String[] args) {
//		System.out.println((int)(Math.random()*100)); 
		// 난수 발생시키는 함수 (실수) (0 <= Math.random() < 1) (실수)
		// 0 <= Math.ramdom()*100 < 100 = 0부터 100 미만의 실수가 발생함 (실수)
		// ******************************************************************
		// 형변환 (int) 사용하면 정수로 변환됨
		// ******* 0 <= ((int)(Math.ramdom()*101)) < 101 = 0부터 101 미만의 정수가 발생함 *********
		int score = ((int)(Math.random()*101)); 
		int temp = (score==100) ? score-1 : score; // score/10으로 나누면 101 입력시 a학점이 나옴. 그렇기 때문에 temp(임시)만들어서 100 이상이 되는Ex04_if_hakjum.java
		switch(temp/10) {
		case 9:
			System.out.println(score + "= A학점");break;
		case 8:
			System.out.println(score + "= B학점");break;
		case 7:
			System.out.println(score + "= C학점");break;
		case 6:
			System.out.println(score + "= D학점");break;
		case 5: case 4: case 3: case 2: case 1:
			System.out.println(score + "= F학점");break;
		default:
			System.out.println(score + "= 유효하지 않는 점수입니다");
//		}
		}
	}
}

