package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenArray {
	public static void main(String[] args) {
		String str = "박보검 설형 수지 고소영 장동건 공유"; //String Tokenizer를 이용해서 나눔
//		String[] arr = {"박보검","설현","수지","고소영","장동건","공유"};
		StringTokenizer tokenizer = new StringTokenizer (str);
		String[] arr = new String[tokenizer.countTokens()];
		int idx = 0;
		while(tokenizer.hasMoreTokens()) {
			arr[idx++] = tokenizer.nextToken();
			//idx++;
		}
		System.out.println("배열에 제대로 들어갔는지?" );
		for (String a : arr) {
			System.out.println(a);
		}
	}
}
