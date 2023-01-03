package com.lec.ex1_trycatch;
// Exception 1�� ó��
import java.util.Scanner;

// ����ڿ��� ���� �Է¹޾� ��Ģ����
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j; // ����ڿ��� �Է� ���� �� ����
		System.out.print("ù ��° ��: ");
		i = sc.nextInt();
		System.out.print("�� ��° ��: ");
		j = sc.nextInt();
		System.out.println("ù ��° ���� "+i+", �� ��° ���� "+j);
		System.out.printf("\n%d * %d = %d\n", i, j, (i*j));
		try { // ���ܰ� �߻��� ���� �ִ� �κ�
		System.out.printf("\n%d / %d = %d\n", i, j, (i/j));// ����ڰ� 0�� �Է��ϸ� ������ �κп��� ArithmeticException �߻� (������ 0���� ���� �� ���� ����)
		}catch(ArithmeticException e) { // ���� �̸� e��� ���� // ���ܰ� �߻����� ���� �����ϴ� �κ�
			System.out.println(e.getMessage()); //���� �޼��� ��� (���� �ȿ��� �޼����� ���� ==> �� �޼����� �����ͼ� �ѷ��߸� � �� ������ ������ �߻��� �� �� �� ����)
		// ���ܰ� �߻��ؾ߸� catch�� ����
		}
		System.out.printf("\n%d + %d = %d\n", i, j, (i+j));
		System.out.printf("\n%d - %d = %d\n", i, j, (i-j));
		System.out.print("\n��");
		sc.close();
	}
}
