package com.lec.ex;
// ������� : + - * / %(������ ������)
public class Ex01 {
	public static void main(String[] args) {
		int n1 = 99, n2 = 10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);

		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result); // �����ô� �� ������ , ���� ��µ�
		
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result); // ������ ������, 
		// ������ �������� �뵵 : ¦Ȧ�� �Ǻ�, ��� �Ǻ�, ...
		
		if(n1%2 == 0) {
			System.out.println("n1�� ¦��");
		}else {
			System.out.println("n1�� Ȧ��"); // ��
		}
		if(n1%2 == 1) {
			System.out.println("n1�� Ȧ��");
		}else {
			System.out.println("n1�� ¦��"); // ����
			
		// ���� �ǵ��� �ٲٴ� ��� (������ ��츦 ���)	
		if(n1%2 == 1 && n1%2 == -1) {
		System.out.println("n1�� Ȧ��");
		}else {
		System.out.println("n1�� ¦��"); // ����
		}	
			
		}
	}
}
