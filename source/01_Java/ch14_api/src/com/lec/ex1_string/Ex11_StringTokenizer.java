package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex11_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 고소영 장동건"; // 데이터 하나를 토큰이라고 부름
		String str2 = "100 / 90 / 85 / 76"; //구분자 데이터를 자를 수 있음 tokenizer
		StringTokenizer tokenizer1 = new StringTokenizer (str1); // 구분자는 space
		StringTokenizer tokenizer2 = new StringTokenizer (str2," / "); // 구분자를 두번째 매개변수에 써줌
		System.out.println("tokenizer1의 토큰 개수 : " +tokenizer1.countTokens());
		System.out.println("tokenizer2의 토큰 개수 : " +tokenizer2.countTokens());
		while(tokenizer1.hasMoreTokens()) {
			System.out.println(tokenizer1.nextToken());
		} 
		while(tokenizer2.hasMoreElements()) {
			System.out.println(tokenizer2.nextElement());
		}
		while(tokenizer1.hasMoreTokens()) {
			System.out.println(tokenizer1.nextToken()); // 이미 앞의 while문에서 맨 아래를 가르키고 있기 때문에 실행하지 않음
		}
	}
}
