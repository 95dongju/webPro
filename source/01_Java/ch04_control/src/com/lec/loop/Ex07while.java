package com.lec.loop;
public class Ex07while {
	public static void main(String[] args) {
		int i=10;
		while (i>0) {
			System.out.println(i+".");
			i--; // 멈추려면 --해서 1개씩 감소시켜야 함.
		}
		
//		for(int i=10 ; i>0 ; i--) {
//			System.out.println(i+".");
//		}
	}
}
