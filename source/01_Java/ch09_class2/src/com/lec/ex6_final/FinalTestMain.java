package com.lec.ex6_final;

import com.lec.constant.Constant;

public class FinalTestMain {
	public static void main(String[] args) {
		double r = 3;
		double area = r * r * Constant.PI; 
		double round = 2 * Constant.PI * r;
		System.out.println("원의 넓이는 " + area);
		System.out.println("원의 둘레는" + round);
	}
}
