package com.lec.ex;
// 형변환
public class VarEx06 {
	public static void main(String[] args) {
		int i = 10;
		double d = 10; // 8byte 변수에 4byte 변수는 들어감 .. 사실 d = 10.0  --> 묵시적 형변환이라고 함 (데이터 손실 없음)
		System.out.println("d = " + d);
		i = (int)10.6; // i는 4byte인데 10.6은 8byte이기 때문에 error남 그래서 4byte로 자름 --> 명시적 형변환 (데이터 손실 있기 때문에 위험할 수 있음)
		System.out.println("i = " + i);
	}
}
