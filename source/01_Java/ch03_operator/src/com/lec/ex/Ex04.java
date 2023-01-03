package com.lec.ex;
// 논리연산자 : &&(AND) 둘 다 True 일때만 트루, ||(OR), !  
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&& : (i<j) && (++j>h) 는" + ((i<j) && (++j>h)) );
		System.out.println("j = " + j ); // j=11
		// && 연산의 경우 좌항값이 false인 경우 우항의 값은 보지 않는다. 
		System.out.println("&& : (i>j) && (++j>h) 는" + ((i>j) && (++j>h)) ); // i>j가 false니 값이 false임. 즉 우항의 값을 실행하지 않음.
		System.out.println("j = " + j );
		
		
		System.out.println("&& : (i<j) || (++j>h) 는" + ((i<j) || (++j>h)) ); // i>j가 true니 우항의 값을 실행하지 않음.
		System.out.println("j = " + j ); // j=11
		// || 연산의 경우 좌항값이 True인 경우 우항의 값은 보지 않는다. 
		System.out.println("&& : (i>j) || (++j<h) 는" + ((i>j) || (++j<h)) ); // i>j가 false니 우항의 값을 실행함.
		System.out.println("j = " + j );
	}
}
