package com.lec.ex3_math;

import java.util.Random;

public class Ex06_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do {
				temp = random.nextInt(45)+1;
				for(j=0 ; j<i ; j++) {
					if(lotto[j] ==temp) {
						System.out.println("중복돼서 다시 함" + temp);
						break;
					} //if - temp랑 같은 번호가 있으면 for문을 빠져나감
				} //for
			}while(i!=j);
			lotto[i] = temp;
		}
		//발생된 로또 번호 출력 >> 중복된 값이 나오면 중복된 값이 안 들어가게 하는 게 컬렉션에서 배움
 		for(int l : lotto) {
			System.out.print(l + "\t");
		}
 		System.out.println("\n정렬 후");
 		//sort- lotto 배열 값을 순서대로 정렬하기
 		for(i=0 ; i<lotto.length-1 ; i++) {
 			
 			for(j=i+1 ; j<lotto.length ; j++) {
 				
 				// 값을 줘서 바꾸려면 임시변수가 필요함
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
