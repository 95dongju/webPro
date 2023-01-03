package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_ScannerObj {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("이름은? ");
		String name = scMain.nextLine();
		System.out.println("입력한 이름은 " +name);
		// 메소드 호출 == 별명을 입력받아 출력하고 끝내는 메소드
		getNickName();
		
		System.out.println("나이는? ");
		int age = scMain.nextInt();
		System.out.println("입력한 나이는 " +age);
		scMain.close();
		
	}

	private static void getNickName() {
		Scanner scNick = new Scanner(System.in); // close 하면 위의 scanner도 닫힘
		System.out.print("별명은? ");
		String nickName = scNick.next();
		System.out.println("입력한 별명은  " +nickName);
	}
}
