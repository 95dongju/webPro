package com.lec.ex3_math;

public class Ex01_Math {
	public static void main(String[] args) {
		int a = 2, b = 10;
		System.out.println("a�� b�� : " +Math.pow(a, b)); //a�� b���� double������ ���� (int)(Math.pow(a, b))); �Ҽ��� ���ַ��� int�� ����ȯ
		System.out.println("-9.9�� ���밪: " +Math.abs(-9.9)); // double���� double�� ����
		System.out.println("a�� b �� �ּڰ�: " +Math.min(a, b));
		System.out.println("a�� b �� �ִ�: " +Math.max(a, b));
		System.out.println("PI = " +Math.PI);
	}
}
