package com.lec.ex6_wrapper;
// java.com.lec.ex6_wrapper.Ex02 10 20 30 1 실행
// 결과: 들어온 값의 갯수: 4
//		들어온 값의 합: 61
// **Integer.parseInt** (string을 int로 바꿔주는 것)
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("들어온 값의 갯수: "+args.length);
		int total = 0; // 누적 변수
		for(int i = 0 ; i<args.length ; i++) {
//			total = total + args[i]; // String이어서 에러 > String을 인트로 바꿔야 함
			total = total + Integer.parseInt(args[i]); // total = total + Integer args
			System.out.println(args[i]);
		}
		System.out.println("들어온 값의 합: " + total);
	}
	
}
