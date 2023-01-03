package com.lec.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int score = 65;
		if(score>=90) {
			System.out.println("참 잘했어요!");
		}else if(score>=70) {
			System.out.println("괜찮습니다");
		}else if(score>=60) {
			System.out.println("분발하세요");
		}else {
			System.out.println("재시험입니다");
		}
	
		System.out.println("DONE");
	}
}
