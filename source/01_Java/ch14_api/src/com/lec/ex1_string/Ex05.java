package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("주민번호를 입력하세요");
		String num = sc.next();
		// 방법 1. char로 추출
		char gender = num.charAt(7);
		if(gender =='1' || gender == '3') {
			System.out.println("남성이시군요");
		}else if (gender == '2' || gender == '4') {
			System.out.println("여성이시군요");
		}else {
			System.out.println("유효하지 않음");
		}
		
		// 방법 2. String으로 추출
		String genderStr = num.substring(7,8); //2
		if(genderStr.equals("1") || genderStr.equals("3")) {
			System.out.println("남성이시군요");
		}else if (genderStr.equals("2") || genderStr.equals("4")) {
			System.out.println("여성이시군요");
		}else {
			System.out.println("유효하지 않음");
		}
		
		// 방법 3. genderStr을 정수로 전환 (정수스트링을 정수로 전환)
		int genderInt = Integer.parseInt(genderStr); //2 --> 숫자
		if(genderInt == 1 || genderInt == 3) {
			System.out.println("남성");
		}else if (genderInt == 2 | genderInt == 4) {
			System.out.println("여성");
		}else {
			System.out.println("유효하지 않음");
		}
		
	}
}
