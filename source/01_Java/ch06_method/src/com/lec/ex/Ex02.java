package com.lec.ex;
// void = �����ϰ� ����, ���� ������ �;� �ϴ� ���� �� ���� Ÿ���� ����
public class Ex02 {
	private static int sum(int from, int to) {
		int sum = 0; //main ������ ������ ������ �ٸ��� ������ �������� ���Ƶ� ��� ���� //������ ����
		for(int i=from ; i<=to ; i++) {
			sum += i;
		}
		return sum; // return �� ȣ���� ������ ���ٴ� ��
	}
	private static String evenOdd(int value) {
		String result = (value%2 == 0) ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		return result;
	}
	// () �Ű�����, �Ķ����)
	public static void main(String[] args) {
		int tot = sum(1,10);
		System.out.println("1���� 10���� ������ ���� " + tot);
		System.out.println (evenOdd(tot));
		// ----------------------------------------------------------
		tot = sum(10,100);
		System.out.println("10���� 100���� ������ ���� " + tot);
		System.out.println (evenOdd(tot));
		// �ڵ带 �����ؾ� �ϴ� ���� ���� ��, �ڵ带 �����ϰų� ���� �ڵ����� �ʰ� �޼ҵ带 �̿���
	}
}
