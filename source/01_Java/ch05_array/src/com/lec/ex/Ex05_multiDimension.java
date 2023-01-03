package com.lec.ex;
//배열은 대부분 1차원 배열을 씀. 특정한 군에서 다차원 배열을 쓰기도 함 (딥러닝, 머신러닝)
public class Ex05_multiDimension {
	public static void main(String[] args) {
		int[] arr = {1,2,3}; //1차원 배열
		System.out.println(arr[0]); // 특정한 방에 있는 인덱스를 불러오려면 arr[0]
		int [][] test = {{1,2,3}, {4,5,6}}; //2차원 배열 > 배열을 배열로 묶음
		test[0][1] = 200;
		// 다차원 배열의 출력
		for(int i=0 ; i<test.length ; i++) { //행
			for(int j=0 ; j<test[i].length ; j++) { //열
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}//for j
		}//for i
	}//main
}//class
