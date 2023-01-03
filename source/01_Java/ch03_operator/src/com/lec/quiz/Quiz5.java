package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		int mat = sc.nextInt();
		int tot = kor+eng+mat;
		double avg = (double)tot / 3; // double avg = sum/3.;
		System.out.printf("총점: %d, 평균: %.2f\n", tot, avg );
		sc.close();

}
}
