package com.lec.ex;
// 증감연산자 : ++(하나 증가), --(하나 감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1;	// n1을 1 증가하고 n2에 할당
		System.out.printf("n1= %d, n2 = %d\n", n1, n2);
		n2 = n1++; 		// n1값을 n2에 할당한 후 1 증가 (증감연산자를 앞에 붙이나, 뒤에 붙이나에 따라 값이 달라짐)
		System.out.printf("n1= %d, n2 = %d\n", n1, n2);
		/*
		 * n2 = n1;
		 * + ++n1;
		 */
		n2 = --n1;
		System.out.printf("n1= %d, n2 = %d\n", n1, n2);
		n2 = n1--;
		System.out.printf("n1= %d, n2 = %d\n", n1, n2);
		
		int a = 1;
		int b = 1;
		System.out.println(a++);
		System.out.println(a);
		System.out.println(++a);
	}
}


