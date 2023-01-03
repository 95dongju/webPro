package com.lec.loop;

import java.util.Scanner;

public class Ex11doWhile_lotto1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int lotto, su;
		lotto = (int)(Math.random()*45)+1; //형변환 하기 위해서는 반드시 괄호로 묶어야 함
		System.out.printf("로또 번호는 %d번입니다\n", lotto);
	}
}

