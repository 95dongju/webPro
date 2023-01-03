package com.lec.method;
// method ����: sum(int, int) > sum(10,100) / sum(10) �Լ��� �Ȱ��� �̸��� ���� ���� ���� - �Լ��� �����ε�
public class Arithmetic {
	public int sum(int from, int to) {
	// �ܺ�(�ش� ���� ���� �ٸ� ����)���� �� �� �ִ�, �Լ� Ÿ��, �Լ���
		int result = 0 ; // ��������
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public int sum(int to) { // 1~to����
		int result = 1;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		return value%2 == 0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
	}
	static int abs(int value) { //���밪�� return. ���������� (private,public) ������ ���? //static�� �ٷ� ��� ����������, ���� ��Ű�� �������� ȣ�� ����
		int result = value>=0? value : -value;
		return result; 
	}
}
