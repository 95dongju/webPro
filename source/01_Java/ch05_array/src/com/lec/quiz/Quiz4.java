package com.lec.quiz;

public class Quiz4 {
	public static void main(String[] args) {
		int num [] = {76,45,34,89,100,50,90,92};
		
		for(int i=0 ; i<num.length-1 ; i++) {
			
			for(int j=i+1 ; j<num.length ; j++) {
				
				if(num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
				}
			}
			for(int a : num) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}
//		for(int a : num) {
//			System.out.print(a + "\t");
//		}
	}
}
