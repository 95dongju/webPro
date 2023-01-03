package com.lec.ex;
// 동등연산/동등관계 연산 : == (같다), != (다르다), (=은 할당 / ==은 같다), <, <=, ...
public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10, n2 = 5;
		boolean result; 
		result = n1>=n2;
		System.out.printf("%d %s %d 는 %b\n", n1, ">=", n2, result);
		result = n1<=n2;
		System.out.printf("%d %s %d 는 %b\n", n1, "<=", n2, result);
		result = n1==n2;
		System.out.printf("%d %s %d 는 %b\n", n1, "==", n2, result);
		result = n1!=n2;
		System.out.printf("%d %s %d 는 %b\n", n1, "!=", n2, result);
		
		result = !(n1!=n2); // 논리연산자 (반대를 의미) **
		System.out.printf("%d %s %d 는 %b\n", n1, "!=", n2, result);
		System.out.println("!(n1!=n2)는 " + result);
	}
}
	
