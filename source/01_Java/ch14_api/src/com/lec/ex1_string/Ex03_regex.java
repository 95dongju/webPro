package com.lec.ex1_string;

public class Ex03_regex {
	public static void main(String[] args) {
	
		/*
		  ����ǥ����(regex) regular expression
		  
		 1. ���� - ��Ű���
		 
		 
		 2. ���� ����
		 \d = ���ڿ� ��ġ�Ѵ� == [0-9]�� ����
		 \D = ���ڰ� �ƴ� �Ͱ� ��ġ�Ѵ�
		 \w = ������ & ���ڿ� ��ġ�Ѵ� == [A-Za-z0-9]
		 \W = ������ & ���ڰ� �ƴ� �Ͱ� ��ġ�Ѵ�
		  . = �ƹ� ���ڿ� ��ġ�Ѵ�
		 \. = .�� �ǹ���
		 [] = �ƽ�Ű�ڵ尪�� ���� �� ������ �Է�
		  + = 1�� �̻� �ݺ�
		  * = 0�� �̻� �ݺ�
		  ? = 0���̳� 1�� �ݺ�
		 {1,3} = 1~3ȸ �ݺ� (�ݵ�� ���� ���� �տ� ��)
		 {2}   = 2ȸ �ݺ�
		 {2,}  = 2ȸ �̻� �ݺ�
		 
		 
		 3. ����ǥ���� ������: https://regexpal.com/
			ex1. ��ȭ��ȣ: [0-2]{2,3}.?\d{3,4}.?\d{4}
			ex2. �ֹι�ȣ: \d{2}[0-1]\d[0-3]\d?-[1-4]\d{6}
			ex3. �̸���:\w+@\w+(\.+\w+){1,2}
			
			
		 4. �ҽ� ����
		 */
		String juminNo = "981212-2054545";
		// Ư�� ����ǥ������ ���ڿ� ����
		System.out.println("�ֹι�ȣ: " +juminNo.replaceAll("-[1-4][0-9]{6}", "-*******"));
		String str = "010-9999-9999 ysieu@gmail.com �ݰ����ϴ�. 981229-2109232������";
		System.out.println("�̸����� ���� str : " +str.replaceAll("\\w+@\\w+(\\.+\\w+){1,2}", ""));
		System.out.println("��ȭ��ȣ ���� str : " +str.replaceAll("[0-2]{2,3}.?\\d{3,4}.?\\d{4}", ""));
		System.out.println("���� ���� str : " +str.replaceAll("[��-��]", ""));
	}
}
