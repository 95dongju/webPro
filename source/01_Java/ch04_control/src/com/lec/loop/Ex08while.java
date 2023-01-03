package com.lec.loop;

public class Ex08while {
	public static void main(String[] args) {
		int tot = 0; //누적합 변수
		int i=1;
		while(i<=10) {
			tot += i;
			System.out.printf("i가 %d일 때, 누적합은 %d이다\n", i, tot);
			i++;
			}
		
		// for문
//		for(int i=1 ; i<=10 ; i++) {
//			// 출력 전 누적 필수! tot += i; //tot = tot i; (자바는 이렇게 안씁니다)
//			tot += i;
//			System.out.printf("i가 %d일 때, 누적합은 %d이다\n", i, tot);
//		}
	}
}
