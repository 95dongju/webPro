package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=0 ; i<11 ; i++) {
			tot += i;
		}
		String result = (tot%2 == 0) ? "짝수입니다" : "홀수입니다";
		System.out.printf("1부터 10까지의 합은 %d이며, %s\n", tot, result);
		// ----------------------------------------------------------
		tot = 0;
		for(int i=10 ; i<101 ; i++) {
			tot += i;
		}
		result = (tot%2 == 0) ? "짝수입니다" : "홀수입니다";
		System.out.printf("10부터 100까지의 합은 %d이며, %s\n", tot, result);
		// 코드를 수정해야 하는 일이 생길 때, 코드를 복사하거나 새로 코딩하지 않고 메소드를 이용함
	}
}
