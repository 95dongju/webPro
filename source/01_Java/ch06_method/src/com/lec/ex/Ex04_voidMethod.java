package com.lec.ex;
// return ���� ���� �޼ҵ� = void
public class Ex04_voidMethod {
	public static void main(String[] args) {
		printLine();
		System.out.println("Hello, world");
		printLine('~');
		System.out.println("\nHello, Java");
		printLine(15);
		System.out.println("\nHello, Program");
		Ex04_voidMethod ex = new Ex04_voidMethod();
		ex.printLine(21,'��');
	}
	private void printLine(int cnt, char ch) { // static�� �� ���� �Ϲ� �޼ҵ�� ������ ������ ��. Ŭ������ ������ ������ ������ ��.
		for (int i=0 ; i<cnt ; i++) {
			System.out.print(ch);
		}
		System.out.println(); //����
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
		System.out.println(); // �⺻ ���� �׸��� ����
	}
}
