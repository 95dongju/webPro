package com.lec.ex1_string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȭ��ȣ�� �Է��ϼ���(xxx-xxxx-xxxx) / ����� X�� �Է��ϼ���");
		while(true) {
			String tel = sc.next();
			if(tel.equalsIgnoreCase("x"))
				break;
			System.out.println("�Է��� ��ȭ��ȣ: "+tel);
			System.out.print("¦����° ���ڿ�: ");
			for(int i = 0 ; i<=tel.length() ; i++) {
				if(i%2==0) {
					System.out.print(tel.charAt(i));
				}
				else if (i%2!=0) {
					System.out.print(" ");
				}
			}
			System.out.print("\n�Ųٷ� ���ڿ�: ");
			for(int i = tel.length()-1; i>=0; i--) {
					System.out.print(tel.charAt(i));					
				}
			StringTokenizer tokenizer = new StringTokenizer(tel,"-");
			String[] arr = new String[tokenizer.countTokens()];
			int idx = 0;
			while(tokenizer.hasMoreTokens()) {
				arr[idx++] = tokenizer.nextToken();
			}				
				System.out.println("\n��ȭ��ȣ ���ڸ�: "+arr[0]);
			System.out.println("��ȭ��ȣ ���ڸ�: "+tel.substring(tel.lastIndexOf("-")+1));
		}System.out.println("�����մϴ�");
	}
}
