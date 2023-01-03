package com.lec.quiz;

public class Ex06_lotto {
	public static void main(String[] args) {
		int[] lotto = {76,45,34,89,100,50,90,92};
		int i, j;
		int temp;

 		for(i=0 ; i<lotto.length-1 ; i++) {
 			
 			for(j=i+1 ; j<lotto.length ; j++) {
 				

 				if(lotto[i] > lotto[j]) {
 					temp = lotto[i];
 					lotto[i] = lotto[j];
 					lotto[j] = temp;
 							
 				}
 			}
 		}
 		for(int l : lotto) {
			System.out.print(l + "\t");
 		}
	}
}
