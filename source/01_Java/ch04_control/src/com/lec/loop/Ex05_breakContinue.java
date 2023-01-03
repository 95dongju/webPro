package com.lec.loop;

public class Ex05_breakContinue {
	public static void main(String[] args) {
		for(int i = 1 ; 1<=5 ; i++) {
			if(i==3) 
				// break; // 반복문 블럭을 빠져나감
				continue; // 반복문 위로 무조건 올라가서 진행함 (결과가 3 빼고 출력됨)
			System.out.print(i);
			System.out.println("\t");
		}
	}
}
