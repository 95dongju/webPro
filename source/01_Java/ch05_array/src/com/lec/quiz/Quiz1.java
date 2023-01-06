package com.lec.quiz;

public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int tot = 0;
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]);
			if(i<arr.length) {
				System.out.print(" + ");
			}else if(i>arr.length) {
				System.out.print(" = ");
			}
			tot += arr[i];
		}
		System.out.print(tot);
	}
}