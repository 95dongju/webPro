package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		String num = sc.next();
		// ��� 1. char�� ����
		char gender = num.charAt(7);
		if(gender =='1' || gender == '3') {
			System.out.println("�����̽ñ���");
		}else if (gender == '2' || gender == '4') {
			System.out.println("�����̽ñ���");
		}else {
			System.out.println("��ȿ���� ����");
		}
		
		// ��� 2. String���� ����
		String genderStr = num.substring(7,8); //2
		if(genderStr.equals("1") || genderStr.equals("3")) {
			System.out.println("�����̽ñ���");
		}else if (genderStr.equals("2") || genderStr.equals("4")) {
			System.out.println("�����̽ñ���");
		}else {
			System.out.println("��ȿ���� ����");
		}
		
		// ��� 3. genderStr�� ������ ��ȯ (������Ʈ���� ������ ��ȯ)
		int genderInt = Integer.parseInt(genderStr); //2 --> ����
		if(genderInt == 1 || genderInt == 3) {
			System.out.println("����");
		}else if (genderInt == 2 | genderInt == 4) {
			System.out.println("����");
		}else {
			System.out.println("��ȿ���� ����");
		}
		
	}
}
