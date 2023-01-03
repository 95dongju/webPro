package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
//		System.out.println("-9의 절대값 : " + Arithmetic.abs(-9)); // public을 생략할 경우, default 접근제한자: 같은 패키지 내에서만 사용 가능함
		Arithmetic ar = new Arithmetic();
		
		int tot = ar.sum(10); // static 메소드가 아니어서 실행 불가능. 일반 메소드는 실행 영역에 올라가는 변수로 만들어야 함. like Scanner처럼 변수 선언해서 불러온 뒤에 이름을 사용해서 불러옴.
		System.out.println("1부터 10까지의 합은: " +tot);
		System.out.println(ar.evenOdd(tot));
		tot = ar.sum(10,100);
		System.out.println("합은 "+tot);
		System.out.println(ar.evenOdd(tot));
	}
}
