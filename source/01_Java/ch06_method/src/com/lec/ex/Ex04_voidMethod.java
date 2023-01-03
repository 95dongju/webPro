package com.lec.ex;
// return 값이 없는 메소드 = void
public class Ex04_voidMethod {
	public static void main(String[] args) {
		printLine();
		System.out.println("Hello, world");
		printLine('~');
		System.out.println("\nHello, Java");
		printLine(15);
		System.out.println("\nHello, Program");
		Ex04_voidMethod ex = new Ex04_voidMethod();
		ex.printLine(21,'＃');
	}
	private void printLine(int cnt, char ch) { // static을 안 쓰는 일반 메소드는 변수를 만들어야 함. 클래스를 가지고 변수를 만들어야 함.
		for (int i=0 ; i<cnt ; i++) {
			System.out.print(ch);
		}
		System.out.println(); //개행
	}
	private static void printLine(int cnt) {
		for(int i=0 ; i<1 ; i++) {
			System.out.println(cnt);
		}
	}

	private static void printLine(char ch) {
		for (int i=0 ; i<80 ; i++) {
			System.out.print(ch);
		}
		
	}

	private static void printLine() {
		for (int i=0 ; i<80 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 기본 라인 그리고 개행
	}
}
