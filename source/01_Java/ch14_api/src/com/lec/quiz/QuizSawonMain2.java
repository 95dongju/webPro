package com.lec.quiz;


public class QuizSawonMain2 {
	public static void main(String[] args) {
		
		Sawon2[] sawons = {new Sawon2("2919828", "ȫ�浿", Dept.COMPUTER),
						new Sawon2("sdsdsd", "sdsd", Dept.ACCOUNTING, 2022,12,15)};
		
		for(int i = 0 ; i <sawons.length ; i++) {
			System.out.println(sawons[i]);
		}
		for(Sawon2 sawon : sawons) {
			System.out.println(sawon);
		}
	}
}
