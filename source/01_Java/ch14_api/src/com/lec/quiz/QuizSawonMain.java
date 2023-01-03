package com.lec.quiz;


public class QuizSawonMain {
	public static void main(String[] args) {
		
		Sawon[] sawons = {new Sawon("2919828", "ȫ�浿", Sawon.COM),
						new Sawon("sdsdsd", "sdsd", Sawon.HUM, 2022,12,15)};
		
		for(int i = 0 ; i <sawons.length ; i++) {
			System.out.println(sawons[i]);
		}
//		for(Sawon sawon : sawons) {
//			System.out.println(sawon);
//		}
	}
}
