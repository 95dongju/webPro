package com.lec.ex1_trycatch;
import java.util.InputMismatchException;
// Exception 2개 처리 (절대 이렇게 하지 마세요!)
import java.util.Scanner;

// 사용자에게 수를 입력받아 사칙연산
public class Ex02_badex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j=1; // 사용자에게 입력 받을 수 저장
		System.out.print("첫 번째 수: ");
		do { // 숫자를 입력할때까지 계속 실행해야 하기 때문에 반드시 한번은 실행하는 doWhile문을 사용해
			try { // 예외가 발생될 수도 있고 안 될 수도 있는 것은 try로 감쌈
				i = sc.nextInt();
				break; // 만약 숫자를 입력해서 i에 들어왔다면 break로 멈춤.
			}catch(InputMismatchException e) { // 문자를 넣으면 발생할 수 있는 에러
				System.out.println("수에 문자를 넣지 마세요"); 
				sc.nextLine(); // 버퍼 지우는 용도 (버퍼에 남아있는 문자를 삭제함)
			} //★★★★★★★★★ 이렇게 하면 계속 에러가 발생함  // 수가 들어가지 않고 계속 i로 들어가서 무한반복문이 됨
		}while(true); //true를 넣으면 무한반복되기 때문에 아래에 에러메세지 뜸 (아래 코드가 실행되지 않기 때문)
		System.out.print("두 번째 수: ");
		try { // 예외가 발생할 수도 있는 부분 / 이렇게 하면 아래 j에 오류가 남 --> j에 쓰레기값 있는 상태에서 예외가 발생하면 j에 여전히 쓰레기값이 남아있음 (초기화 되지않음)
//			try { // try 안에 try 넣지 않음 / try 하나에 캐치절을 여러개 만든다
				j = sc.nextInt(); // 잘 입력되면 catch절 무시, 만약 문자를 입력하면 arithmetic 객체 만들어지고 수행 > 다른 catch절은 무시, 
			System.out.println("첫 번째 수는 "+i+", 두 번째 수는 "+j);
			System.out.printf("\n%d * %d = %d\n", i, j, (i*j));
			System.out.printf("\n%d / %d = %d\n", i, j, (i/j));// 사용자가 0을 입력하면 나누기 부분에서 ArithmeticException 발생 (정수를 0으로 나눌 수 없기 때문)
//		}catch(ArithmeticException e) { // 변수 이름 e라고 저장 // 예외가 발생했을 때만 실행하는 부분
//			System.out.println(e.getMessage()); //예외 메세지 출력 (에러 안에는 메세지가 있음 ==> 즉 메세지를 가져와서 뿌려야만 어떤 것 때문에 문제가 발생한 지 알 수 있음)
//			e.printStackTrace(); // 몇번째 줄에서 예외가 발생했다는 걸 알려줌
//		// 예외가 발생해야만 catch절 수행
			}catch (InputMismatchException e) {
				System.out.println("예외 메세지: "+e.getMessage());
				System.out.println("두번째 정수를 잘못 입력하셔서 1로 세팅합니다");
			}catch (Exception e) { // Exception은 항상 캐치절의 아래로
				System.out.println(e.getMessage());
			}
		System.out.printf("\n%d + %d = %d\n", i, j, (i+j));
		System.out.printf("\n%d - %d = %d\n", i, j, (i-j));
		System.out.print("\n끝");
		sc.close();
	}
}
