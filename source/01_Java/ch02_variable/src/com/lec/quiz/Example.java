package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		System.out.println("�ǽ� ���� : ����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� ����, ��� ����ϴ� ���α׷��� �����Ͻÿ�.");
		int kor = 100;
		int eng = 99;
		int mat = 100;
		int tot = kor+eng+mat;
		System.out.println("���� = " +kor +"��");
		System.out.println("���� = " +eng +"��");
		System.out.println("���� = " +mat +"��");
		double avg = (double)tot / 3;
		System.out.printf("���� = %d\t ��� = %.2f\n", tot, avg);
		
	}
}
