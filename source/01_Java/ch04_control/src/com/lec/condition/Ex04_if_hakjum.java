package com.lec.condition;

import java.util.Scanner;

//점수를 입력받아 학점 출력
public class Ex04_if_hakjum {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		//90<=score<100 (삼항연산자는 if문으로 들어가면 오류남, 파이썬으로는 가능) (이항연산자이기 때문에 반드시 && 사용)
		//
		if(90<=score && score<=100) {
			System.out.println("A학점");
		}else if(80<=score && score<=90) {
			System.out.println("B학점");
		}else if(70<=score && score<=80) {
			System.out.println("C학점");
		}else if(60<=score && score<=70) {
			System.out.println("D학점");
		}else if(0<=score && score<=60) {
			System.out.println("F학점");
		}else {
			System.out.println("유효하지 않는 점수입니다");
		}
		sc.close();
	}
}

