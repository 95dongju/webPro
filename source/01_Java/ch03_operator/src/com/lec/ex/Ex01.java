package com.lec.ex;
// 산술연산 : + - * / %(나머지 연산자)
public class Ex01 {
	public static void main(String[] args) {
		int n1 = 99, n2 = 10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);

		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result); // 슬래시는 몫 연산자 , 몫이 출력됨
		
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result); // 나머지 연산자, 
		// 나머지 연산자의 용도 : 짝홀수 판별, 배수 판별, ...
		
		if(n1%2 == 0) {
			System.out.println("n1은 짝수");
		}else {
			System.out.println("n1은 홀수"); // 참
		}
		if(n1%2 == 1) {
			System.out.println("n1은 홀수");
		}else {
			System.out.println("n1은 짝수"); // 거짓
			
		// 참이 되도록 바꾸는 방법 (음수일 경우를 대비)	
		if(n1%2 == 1 && n1%2 == -1) {
		System.out.println("n1은 홀수");
		}else {
		System.out.println("n1은 짝수"); // 거짓
		}	
			
		}
	}
}
