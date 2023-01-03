package com.lec.quiz;

import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int me, com;
		do {
			com = random.nextInt(3);
			System.out.print("가위, 바위, 보 중 하나 ");
			String meStr = sc.next().trim();
			if (meStr.equals("가위")) {
				me = 0;
			}else if (meStr.equals("바위")) {
				me = 1;
			}else if (meStr.equals("보")) {
				me = 2;
			}else {
				me = -1;
				continue;
			}
			
			if((me+2)%3==com){
				printResult(me, com);
				System.out.println("당신이 이겼어요");
			break;
			}else if(me==com){
				printResult(me, com);
				System.out.println("비겼어요");
			}else{
				printResult(me, com);
				System.out.println("당신이 졌어요");
				
			}//if
			
		}while(true);
		System.out.println("축하해요. BYE");
		sc.close();
	} // main
	private static void printResult(int me, int computer) {
		System.out.println("당신은 "+((me==0)?"가위":((me==1)?"바위":"보")));
		System.out.println("컴퓨터는 "+((computer==0)?"가위":((computer==1)?"바위":"보")));		
	} // printResult
} // class


