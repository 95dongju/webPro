package com.lec.loop;

import java.util.Scanner;

public class Ex13doWhile_lotto3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int lotto, su;
		int min=1, max=45;
		lotto = (int)(Math.random()*45)+1;
		do {
			System.out.printf("%d부터 %d까지 로또 번호를 맞춰 보세요 : \n", min, max);
			su = sc.nextInt();
			if(su<min || su>max) {
				System.out.println("범위를 확인하세요.");
			}else if (su>lotto) {
				max = su-1;
				//System.out.println(su+"보다 작은 수를 도전하세요");
			}else if (su<lotto) {
				min = su+1;
				//System.out.println(su+"보다 큰 수를 도전하세요");
			}
		}while(su!=lotto);
		System.out.printf("축하합니다! 로또 번호는 %d 입니다!\n", lotto);
	}
}

