package com.lec.ex1_string;

public class Ex08_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, Java";
		//str�� �ּ� ����� �ȵ� -> �ؽ��ڵ�� ��ü
		System.out.println("str�� �ؽ��ڵ� : " +str.hashCode());
		str = "hello";
		System.out.println("str�� ���� �� �ؽ��ڵ� : " +str.hashCode());
		// ��Ʈ���� �޸� ���� ����� ������ String Buffer�� ��ü -> �ӵ��� ������ ��
	}
}
