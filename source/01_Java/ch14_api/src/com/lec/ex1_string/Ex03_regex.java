package com.lec.ex1_string;

public class Ex03_regex {
	public static void main(String[] args) {
	
		/*
		  정규표현식(regex) regular expression
		  
		 1. 참고 - 위키백과
		 
		 
		 2. 간략 문법
		 \d = 숫자와 매치한다 == [0-9]와 동일
		 \D = 숫자가 아닌 것과 매치한다
		 \w = 영문자 & 숫자와 매치한다 == [A-Za-z0-9]
		 \W = 영문자 & 숫자가 아닌 것과 매치한다
		  . = 아무 문자와 매치한다
		 \. = .의 의미함
		 [] = 아스키코드값이 작은 것 순서로 입력
		  + = 1번 이상 반복
		  * = 0번 이상 반복
		  ? = 0번이나 1번 반복
		 {1,3} = 1~3회 반복 (반드시 작은 수가 앞에 옴)
		 {2}   = 2회 반복
		 {2,}  = 2회 이상 반복
		 
		 
		 3. 정규표현식 연습장: https://regexpal.com/
			ex1. 전화번호: [0-2]{2,3}.?\d{3,4}.?\d{4}
			ex2. 주민번호: \d{2}[0-1]\d[0-3]\d?-[1-4]\d{6}
			ex3. 이메일:\w+@\w+(\.+\w+){1,2}
			
			
		 4. 소스 구현
		 */
		String juminNo = "981212-2054545";
		// 특정 정규표현식의 문자열 변경
		System.out.println("주민번호: " +juminNo.replaceAll("-[1-4][0-9]{6}", "-*******"));
		String str = "010-9999-9999 ysieu@gmail.com 반갑습니다. 981229-2109232ㅋㅋㅋ";
		System.out.println("이메일을 지운 str : " +str.replaceAll("\\w+@\\w+(\\.+\\w+){1,2}", ""));
		System.out.println("전화번호 지운 str : " +str.replaceAll("[0-2]{2,3}.?\\d{3,4}.?\\d{4}", ""));
		System.out.println("자음 지운 str : " +str.replaceAll("[ㄱ-ㅎ]", ""));
	}
}
