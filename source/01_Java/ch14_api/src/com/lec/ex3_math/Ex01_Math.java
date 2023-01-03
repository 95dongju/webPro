package com.lec.ex3_math;

public class Ex01_Math {
	public static void main(String[] args) {
		int a = 2, b = 10;
		System.out.println("a의 b승 : " +Math.pow(a, b)); //a의 b승을 double형으로 리턴 (int)(Math.pow(a, b))); 소수점 없애려면 int로 형변환
		System.out.println("-9.9의 절대값: " +Math.abs(-9.9)); // double값을 double로 리턴
		System.out.println("a와 b 중 최솟값: " +Math.min(a, b));
		System.out.println("a와 b 중 최댓값: " +Math.max(a, b));
		System.out.println("PI = " +Math.PI);
	}
}
