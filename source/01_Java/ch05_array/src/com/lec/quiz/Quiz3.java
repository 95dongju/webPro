package com.lec.quiz;

public class Quiz3 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coin = {500, 100, 50, 10};
		for(int i=0 ; i<coin.length ; i++) {
			System.out.print((int)coin[i]+"��¥�� "+(int)money/coin[i]+"�� ");
			money %= coin[i];
		}
	}
}
