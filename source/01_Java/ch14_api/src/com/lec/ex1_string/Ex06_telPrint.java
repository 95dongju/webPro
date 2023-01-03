package com.lec.ex1_string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호를 입력하세요(xxx-xxxx-xxxx) / 종료는 X를 입력하세요");
		while(true) {
			String tel = sc.next();
			if(tel.equalsIgnoreCase("x"))
				break;
			System.out.println("입력한 전화번호: "+tel);
			System.out.print("짝수번째 문자열: ");
			for(int i = 0 ; i<=tel.length() ; i++) {
				if(i%2==0) {
					System.out.print(tel.charAt(i));
				}
				else if (i%2!=0) {
					System.out.print(" ");
				}
			}
			System.out.print("\n거꾸로 문자열: ");
			for(int i = tel.length()-1; i>=0; i--) {
					System.out.print(tel.charAt(i));					
				}
			StringTokenizer tokenizer = new StringTokenizer(tel,"-");
			String[] arr = new String[tokenizer.countTokens()];
			int idx = 0;
			while(tokenizer.hasMoreTokens()) {
				arr[idx++] = tokenizer.nextToken();
			}				
				System.out.println("\n전화번호 앞자리: "+arr[0]);
			System.out.println("전화번호 뒷자리: "+tel.substring(tel.lastIndexOf("-")+1));
		}System.out.println("종료합니다");
	}
}
