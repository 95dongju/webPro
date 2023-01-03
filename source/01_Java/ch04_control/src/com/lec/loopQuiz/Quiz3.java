package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("1~9까지 숫자를 입력해 주세요 : ");
		int dansu = sc.nextInt();
		for(int i=1 ; i<10 ; i++) {
			System.out.println(dansu+"*"+i+"="+(dansu*1));
		}
		sc.close();
		
	}
}
