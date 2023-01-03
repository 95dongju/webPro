package com.lec.quiz;

import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper2 {
	public static final int Scissor = 0;
	public static final int Rock = 1;
	public static final int Paper = 2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int me;
		int com;
		do {
			com = random.nextInt(3);
			System.out.print("����, ����, �� �� �ϳ� ");
			String meStr = sc.next().trim();
			if (meStr.equals("����")) {
				me = Scissor;
			}else if (meStr.equals("����")) {
				me = Rock;
			}else if (meStr.equals("��")) {
				me = Paper;
			}else {
				continue;
			}
			
			if((me+2)%3==com){
				printResult(me, com);
				System.out.println("����� �̰���");
			break;
			}else if(me==com){
				printResult(me, com);
				System.out.println("�����");
			}else{
				printResult(me, com);
				System.out.println("����� �����");
				
			}//if
			
		}while(true);
		System.out.println("�����ؿ�. BYE");
		sc.close();
	} // main
	private static void printResult(int me, int computer) {
		System.out.println("����� "+((me==0)?"����":((me==1)?"����":"��")));
		System.out.println("��ǻ�ʹ� "+((computer==0)?"����":((computer==1)?"����":"��")));		
	} // printResult
} // class


