package com.lec.ex5_scanner;
// 1.나이(nextInt) 2.이름(next) 3.주소(nextLine)
//
import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이는 "+age+"살");
		System.out.print("이름을 입력하세요: ");
		String name = scanner.next();
		System.out.println("입력한 이름은 "+name+" 입니다");
		System.out.print("주소를 입력하세요: ");
		scanner.nextLine();
		// 버퍼에 남아있는 "\n"을 지워야 함
		String address = scanner.nextLine(); // "\n"앞의 값을 return하고 "\n" 뒤는 지운다
		System.out.println("입력한 주소는 "+address);
		scanner.close();
	}
}
