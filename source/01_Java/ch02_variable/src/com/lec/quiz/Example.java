package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		System.out.println("실습 예제 : 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균 출력하는 프로그램을 구현하시오.");
		int kor = 100;
		int eng = 99;
		int mat = 100;
		int tot = kor+eng+mat;
		System.out.println("국어 = " +kor +"점");
		System.out.println("영어 = " +eng +"점");
		System.out.println("수학 = " +mat +"점");
		double avg = (double)tot / 3;
		System.out.printf("총점 = %d\t 평균 = %.2f\n", tot, avg);
		
	}
}
