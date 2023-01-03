package com.lec.ex;
// void = 실행하고 끝냄, 값을 가지고 와야 하는 것은 그 값의 타입을 적음
public class Ex02 {
	private static int sum(int from, int to) {
		int sum = 0; //main 변수와 나눠짐 지역이 다르기 때문에 변수명이 같아도 상관 없음 //누적할 변수
		for(int i=from ; i<=to ; i++) {
			sum += i;
		}
		return sum; // return 은 호출한 곳으로 간다는 뜻
	}
	private static String evenOdd(int value) {
		String result = (value%2 == 0) ? "짝수입니다" : "홀수입니다";
		return result;
	}
	// () 매개변수, 파라미터)
	public static void main(String[] args) {
		int tot = sum(1,10);
		System.out.println("1부터 10까지 정수의 합은 " + tot);
		System.out.println (evenOdd(tot));
		// ----------------------------------------------------------
		tot = sum(10,100);
		System.out.println("10부터 100까지 정수의 합은 " + tot);
		System.out.println (evenOdd(tot));
		// 코드를 수정해야 하는 일이 생길 때, 코드를 복사하거나 새로 코딩하지 않고 메소드를 이용함
	}
}
