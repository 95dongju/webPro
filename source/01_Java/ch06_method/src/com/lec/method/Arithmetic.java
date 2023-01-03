package com.lec.method;
// method 모음: sum(int, int) > sum(10,100) / sum(10) 함수는 똑같은 이름의 변수 생성 가능 - 함수의 오버로딩
public class Arithmetic {
	public int sum(int from, int to) {
	// 외부(해당 파일 말고 다른 파일)에서 쓸 수 있는, 함수 타입, 함수명
		int result = 0 ; // 누적변수
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public int sum(int to) { // 1~to까지
		int result = 1;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		return value%2 == 0 ? "짝수입니다" : "홀수입니다";
	}
	static int abs(int value) { //절대값을 return. 접근제한자 (private,public) 생략할 경우? //static은 바로 사용 가능하지만, 같은 패키지 내에서만 호출 가능
		int result = value>=0? value : -value;
		return result; 
	}
}
