package com.lec.ex;

// main ctrl space
// 변수 선언하는 법
public class VarEx03 {
	public static void main(String[] args) {
		// 1. 자료형 변수명; - 변수 선언과 할당을 분리
		int num1; // 변수 선언
		num1 = 10; // 할당
		System.out.println(num1);
		// 2. 자료형 변수명 할당연산자(=) 값; - 변수 선언과 할당을 동시에 함 = 초기화라고 함(할당)
		int num2 = 20;
		System.out.printf("num1 = %d, num2 = %d\n", num1, num2); // 위에서 아래 차례대로 
		// alt + 화살표 누르면 줄 옮김 됨 / alt + 슬래시 누르면 자동 주석처리 됨 / 반드시 변수에 유의미한 값이 할당되어야 함 / ctrl shift f 자동 들여쓰기
		// 3. 자료형 변수1, 변수2, ...; - 동일 자료형의 변수를 다수 선언 (비슷한 유형의 변수 선언)
		int num3, num4; // 노란 밑줄은 warning error - 실행하는 데에 문제는 없지만 '이상한 것'
		num3 = 30; num4 = 40;
		System.out.printf("num3 = %d, num4 = %d\n", num3, num4);
		// 4. 자료형 변수1=값1, 변수2=값2, ...; - 동일자료형 변수를 다수 선언과 초기화
		int num5=50, num6=60;
		System.out.printf("num5 = %d, num6 = %d\n", num5, num6);
	}
}
