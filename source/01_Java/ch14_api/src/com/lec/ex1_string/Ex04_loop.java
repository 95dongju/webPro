package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_loop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // in - static
		String fn; //여기서 선언해야 함 dowhile문 밖에서 물어볼 것이기 때문
		do {
			System.out.print("I:input / U:update / X:exit");
			fn = scanner.next(); // "i" "u" "x"
			switch(fn ) {
			case "i": case "I":
				System.out.println("입력로직"); break;
			case "u": case "U":
				System.out.println("업데이트 로직");break;
			}
		}while(!fn.equals("x") && !fn.equals("X"));
		
	}
}
