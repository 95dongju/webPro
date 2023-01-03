package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("주소는 : ");
//		scan.nextLine(); // 버퍼가 비어있을 때는 버퍼를 지우면 안됨. 그러면 버퍼에 들어가기 때문에 값이 출력되지 않음
		String address = scan.nextLine();
		System.out.println("입력 주소는 " +address);
		System.out.println("나이: ");
		int age = scan.nextInt();
		System.out.println("나이는 " +age);
		System.out.println("이름: ");
		// 나이를 nextInt로 받았기 때문에 버퍼에 "\n"이 있는 상태
		scan.nextLine(); // 버퍼 지우기 목적
		String name = scan.nextLine();
		System.out.println("이름은 " +name);
		System.out.println("프로그램 끝");
	}
}
