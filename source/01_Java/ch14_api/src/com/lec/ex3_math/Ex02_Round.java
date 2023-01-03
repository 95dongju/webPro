package com.lec.ex3_math;
// 올림, 반올림, 버림...
// Math.ceil(올릴 실수) => double값 return		ex. Math.ceil(9.1) -> 10.0
// Math.round(반올림할 실수) => long값 return	ex. Math.round(9.1) -> 9
// Math.floor(버릴 실수) => double값 return		ex. Math.floor(9.99) -> 9.0
public class Ex02_Round {
	public static void main(String[] args) {
		
		//1.
		System.out.println("소수점에서 반올림, 올림, 버림"); //Math에서 제공하는 것
		
		System.out.println("9.15를 올림: " +Math.ceil(9.15));
		System.out.println("9.15를 올림: " +(int)Math.ceil(9.15)); //int로 형변환	
		System.out.println("9.15를 반올림 :" +Math.round(9.15)); // long 정수 return
		System.out.println("9.15를 반올림 :" +(double)Math.round(9.15));	
		System.out.println("9.15를 버림 :" +Math.floor(9.15));
		System.out.println("9.15를 버림 :" +(int)Math.floor(9.15));
		
		
		//2.
		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		
		System.out.println("9.15를 소수점 한자리에서 올림: " +Math.ceil(9.15 * 10)/10);
		System.out.println("9.15를 소수점 한자리에서 반올림: " +Math.round(9.15 * 10)/10.0); // round를 할 때는 10.0을 나눔
		System.out.println("9.15를 소수점 한자리에서 버림: " +Math.floor(9.15 * 10)/10);
		
		
		//3.
		System.out.println("일의 자리에서 반올림, 올림, 버림");
		
		System.out.println("85를 일의 자리에서 올림: " +Math.ceil(85/10.0) * 10);
		System.out.println("85를 일의 자리에서 올림: " +(int)Math.ceil(85/10.0) * 10);
		System.out.println("85를 일의 자리에서 반올림: " +Math.round(85/10.0) * 10);
		System.out.println("85를 일의 자리에서 내림: " +(int)Math.floor(85/10.0) * 10);	
	}
}
