package com.lec.ex;
// ����ȯ
public class VarEx06 {
	public static void main(String[] args) {
		int i = 10;
		double d = 10; // 8byte ������ 4byte ������ �� .. ��� d = 10.0  --> ������ ����ȯ�̶�� �� (������ �ս� ����)
		System.out.println("d = " + d);
		i = (int)10.6; // i�� 4byte�ε� 10.6�� 8byte�̱� ������ error�� �׷��� 4byte�� �ڸ� --> ����� ����ȯ (������ �ս� �ֱ� ������ ������ �� ����)
		System.out.println("i = " + i);
	}
}
