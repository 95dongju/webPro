package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ��� : ");
		int kor = sc.nextInt();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int eng = sc.nextInt();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int mat = sc.nextInt();
		int tot = kor+eng+mat;
		double avg = (double)tot / 3; // double avg = sum/3.;
		System.out.printf("����: %d, ���: %.2f\n", tot, avg );
		sc.close();

}
}
