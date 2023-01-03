package com.lec.ex;

import java.util.Scanner;

// 영희, 철수, 길동, 영수, 말자의 키를 입력받고, 평균치를 구하기
// 가장 큰 학생과 가장 작은 학생
public class Ex04_height2 {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수","길동", "영수", "말자"};
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totHeight = 0;
		// 영희부터 키 입력 받기 > totHeight에 누적해야 함
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는 ? : ");
			arrHeight[idx] = sc.nextInt();
			totHeight += arrHeight[idx]; // 누적 = 평균값 내기 위해서 
		}
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.printf("%d번째 %s의 키는 %d\n", idx, arrName[idx], arrHeight[idx]);
		}
		System.out.println("평균키는 " +(double)totHeight/(double)arrHeight.length);
		sc.close();
		int maxIdx=0, maxHeight=0;  // 최장신을 구하기 위한 변수들 (작은값으로 초기화)
		int minIdx=0, minHeight=9999; // 최단신을 구하기 위한 변수들(큰값으로 초기화)
		for(int idx=0 ; idx<arrName.length ; idx++) {
			if(arrHeight[idx] > maxHeight) {
				maxHeight = arrHeight[idx];
				maxIdx = idx;
			} //if max
			if(arrHeight[idx] < minHeight) {
				minHeight = arrHeight[idx];
				minIdx = idx;
			} //if min
		} //for
		System.out.printf("가장 큰 사람은 %s, %d cm\n", arrName[maxIdx], maxHeight);
		System.out.printf("가장 작은 사람은 %s, %d cm\n", arrName[minIdx], minHeight);
	} //main
} //class
