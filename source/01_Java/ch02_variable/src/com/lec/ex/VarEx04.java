package com.lec.ex;

public class VarEx04 {
	public static void main(String[] args) {
		// 변수 선언은 위치 제약이 없다. 다만 위에 선언할 것을 추천.
		char c = '씨'; //2byte
		int i = 20; //4byte
		long l = 2200000000L; // 8byte 소수점이 없으면 무조건 int, 소수점 있으면 무조건 double - 22억 넘는 정수면 뒤에 L/l 붙이기
		System.out.println("l = " + l);
		float f = 3.14159265359F; // 4byte 더블이 아니라 플로트라는 뜻으로 뒤에 F 붙이기 - 소수점 값이 유실되기 때문에 float 사용은 자제, double 사용하기
		System.out.println("f = " + f);
		double d = 3.14159265359; // 8byte
		System.out.println("t = " + d);
		boolean b = true; // 1byte 참/거짓 대소문자 구분하여 반드시 소문자로 작성
		System.out.println("b = " + b);
		if(f == d) {// == 같은 건지 물어보는 것, 같다면 아래의 첫번째 라인 값을 출력, 다르다면 두번째 라인 값을 출럭함
			System.out.println("f와 t값은 같다");
		}else {
			System.out.println("f와 t값은 다르다"); // 다르다고 출력됨
		}
		
		
		f = 10.1F; 
		d = 10.1;
		if(f == d) {
			System.out.println("f와 t값은 같다");
		}else {
			System.out.println("f와 t값은 다르다"); // 내부적으로는 다르다고 출력되기 때문에 double 사용하기!!
			}
		
		// 정수(4byte)랑 실수(8byte)랑 연산한 결과 : i+d 8byte // 더 많은 바이트값으로 계산됨
		System.out.println("i + d = " +(i+d)); //더 많은 바이트 값으로 계산됨
		
		//정수(4byte)랑 실수(4byte)랑 연산한 결과 : 4byte
		System.out.println("i + i = " +(i+i));
		
		//정수를 나누기??? 하면 몫만 나옴
		System.out.println("i / 7 = " +(i/7));
		
	}
}


