package com.lec.ex;
// 배열 복제
public class Ex03_arrayCopy {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
		System.arraycopy(score, 0, s, 0, score.length); // 알아서 카피하는 모듈
		// int[] s = score; xxxx 복제 아님 . s도 공간을 만들어야 하기 때문에 new로 메모리 확보 필요함.
		//아래의 복제 모듈이 있음 System.arraycopy(어떤 걸 카피?, 어디부터?, 뭘로 카피?, 어디부터?, 길이는?)
//		int[] s = new int[score.length]; //5로 하면 안됨. score 방을 복제하기 때문에 score.length 공간 확보 필요.
//		for(int idx=0 ; idx<s.length ; idx++) {
//			s[idx] = score[idx];
//		}
		s[0] = 999;
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.printf("score[%d] = %d\t / s[%d] = %d\n", idx, score[idx], idx, s[idx]);
		}
	}
}

