package com.lec.ex;
// println() : �ܼ�â ���(��������)
// print() : �ܼ�â ���(���� ������)
// printf() : �ܼ�â ��� (���� ����)
public class VarEx02 {
	public static void main(String[] args) {
		//Ÿ��+������+�Ҵ翬����(=)+��;
		int i = 10;
		byte j = 127;
		double h = 10.15;
		double q = 10.1029292293818382838;
		i = 100;
		System.out.println("i=" + i + "\tj=" + j + "\th=" + h);
		System.out.printf("i=%d \t j=%d \t h=%.2f \t q=%f\n", i, j, h, q);
		char c1 = 'A';
		char c2 = 'B';
		char c3 = '@';
		//%c: ����, %s: ���ڿ�, %d: ����, %f: �Ǽ�, %b: boolean
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		System.out.printf("c1=%d, \t c2=%d, \t c3=%d\n", (int)c1, (int)c2, (int)c3);
		System.out.println("���α׷� ��");
	}
}