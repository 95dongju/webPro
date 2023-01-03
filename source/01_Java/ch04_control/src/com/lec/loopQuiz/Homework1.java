package com.lec.loopQuiz;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int you, com;
		while(true) {
			System.out.println("가위(0), 바위(1), 보(2) 중 하나를 입력하세요.");
			you = sc.nextInt();
			if(you==-1) break;
			com = (int)(Math.random()*3);
			String comStr = (com==0) ? "가위" : (com==1) ? "바위" : "보";
			String youStr = (you==0) ? "가위" : (you==1) ? "바위" : "보";
			if(you<-1 || you>2) {
				System.out.print("가위(0), 바위(1), 보(2) 중 하나를 입력하세요.");
			}else {
				if((you+2)%3 == com) {
					System.out.printf("당신은 %s, 컴퓨터는 %s, 당신이 이겼어요!\n", youStr, comStr);
				}else if ((you+1)%3 == com) {
					System.out.printf("당신은 %s, 컴퓨터는 %s, 컴퓨터가 이겼어요!\n", youStr, comStr);
				}else {
					System.out.printf("당신은 %s, 컴퓨터는 %s, 같은 것을 내셨네요!\n", youStr, comStr);
				}	
			}
		}sc.close();
		System.out.println("BYE");
	}
}