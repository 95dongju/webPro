package com.lec.ex1_trycatch;
// Exception 1개 처리
import java.util.Scanner;

// 사용자에게 수를 입력받아 사칙연산
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j; // 사용자에게 입력 받을 수 저장
		System.out.print("첫 번째 수: ");
		i = sc.nextInt();
		System.out.print("두 번째 수: ");
		j = sc.nextInt();
		System.out.println("첫 번째 수는 "+i+", 두 번째 수는 "+j);
		System.out.printf("\n%d * %d = %d\n", i, j, (i*j));
		try { // 예외가 발생할 수도 있는 부분
		System.out.printf("\n%d / %d = %d\n", i, j, (i/j));// 사용자가 0을 입력하면 나누기 부분에서 ArithmeticException 발생 (정수를 0으로 나눌 수 없기 때문)
		}catch(ArithmeticException e) { // 변수 이름 e라고 저장 // 예외가 발생했을 때만 실행하는 부분
			System.out.println(e.getMessage()); //예외 메세지 출력 (에러 안에는 메세지가 있음 ==> 즉 메세지를 가져와서 뿌려야만 어떤 것 때문에 문제가 발생한 지 알 수 있음)
		// 예외가 발생해야만 catch절 수행
		}
		System.out.printf("\n%d + %d = %d\n", i, j, (i+j));
		System.out.printf("\n%d - %d = %d\n", i, j, (i-j));
		System.out.print("\n끝");
		sc.close();
	}
}
