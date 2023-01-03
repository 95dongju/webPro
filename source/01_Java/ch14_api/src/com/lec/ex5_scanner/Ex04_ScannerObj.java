package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex04_ScannerObj {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("이름은? ");
		String name = scMain.nextLine();
		System.out.println("입력한 이름은 " +name);

		getNickName(scMain); // scanner 객체를 getNickName으로 전달
		
		System.out.println("나이는? ");
		int age = scMain.nextInt();
		System.out.println("입력한 나이는 " +age);
		scMain.close();
		
	}

	private static void getNickName(Scanner scMain) { // 변수 타입을 다 적어줘야 함
		System.out.print("별명은? ");
		String nickName = scMain.next();
		System.out.println("입력한 별명은  " +nickName);
	}
}
