package com.lec.loop;

import java.util.Scanner;

public class Ex12doWhile_lotto2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int lotto, su;
		lotto = (int)(Math.random()*45)+1;
		do {
			System.out.print("로또 번호를 맞춰 보세요 : ");
			su = sc.nextInt();
			if (su>lotto) {
				System.out.println(su+"보다 작은 수를 도전하세요");
			}else if (su<lotto) {
				System.out.println(su+"보다 큰 수를 도전하세요");
			}
		}while(su!=lotto);
		System.out.printf("축하합니다! 로또 번호는 %d 입니다!\n", lotto);
	}
}

