package com.lec.ex1_trycatch;
import java.util.InputMismatchException;
// Exception 2�� ó�� (���� �̷��� ���� ������!)
import java.util.Scanner;

// ����ڿ��� ���� �Է¹޾� ��Ģ����
public class Ex02_badex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j=1; // ����ڿ��� �Է� ���� �� ����
		System.out.print("ù ��° ��: ");
		do { // ���ڸ� �Է��Ҷ����� ��� �����ؾ� �ϱ� ������ �ݵ�� �ѹ��� �����ϴ� doWhile���� �����
			try { // ���ܰ� �߻��� ���� �ְ� �� �� ���� �ִ� ���� try�� ����
				i = sc.nextInt();
				break; // ���� ���ڸ� �Է��ؼ� i�� ���Դٸ� break�� ����.
			}catch(InputMismatchException e) { // ���ڸ� ������ �߻��� �� �ִ� ����
				System.out.println("���� ���ڸ� ���� ������"); 
				sc.nextLine(); // ���� ����� �뵵 (���ۿ� �����ִ� ���ڸ� ������)
			} //�ڡڡڡڡڡڡڡڡ� �̷��� �ϸ� ��� ������ �߻���  // ���� ���� �ʰ� ��� i�� ���� ���ѹݺ����� ��
		}while(true); //true�� ������ ���ѹݺ��Ǳ� ������ �Ʒ��� �����޼��� �� (�Ʒ� �ڵ尡 ������� �ʱ� ����)
		System.out.print("�� ��° ��: ");
		try { // ���ܰ� �߻��� ���� �ִ� �κ� / �̷��� �ϸ� �Ʒ� j�� ������ �� --> j�� �����Ⱚ �ִ� ���¿��� ���ܰ� �߻��ϸ� j�� ������ �����Ⱚ�� �������� (�ʱ�ȭ ��������)
//			try { // try �ȿ� try ���� ���� / try �ϳ��� ĳġ���� ������ �����
				j = sc.nextInt(); // �� �ԷµǸ� catch�� ����, ���� ���ڸ� �Է��ϸ� arithmetic ��ü ��������� ���� > �ٸ� catch���� ����, 
			System.out.println("ù ��° ���� "+i+", �� ��° ���� "+j);
			System.out.printf("\n%d * %d = %d\n", i, j, (i*j));
			System.out.printf("\n%d / %d = %d\n", i, j, (i/j));// ����ڰ� 0�� �Է��ϸ� ������ �κп��� ArithmeticException �߻� (������ 0���� ���� �� ���� ����)
//		}catch(ArithmeticException e) { // ���� �̸� e��� ���� // ���ܰ� �߻����� ���� �����ϴ� �κ�
//			System.out.println(e.getMessage()); //���� �޼��� ��� (���� �ȿ��� �޼����� ���� ==> �� �޼����� �����ͼ� �ѷ��߸� � �� ������ ������ �߻��� �� �� �� ����)
//			e.printStackTrace(); // ���° �ٿ��� ���ܰ� �߻��ߴٴ� �� �˷���
//		// ���ܰ� �߻��ؾ߸� catch�� ����
			}catch (InputMismatchException e) {
				System.out.println("���� �޼���: "+e.getMessage());
				System.out.println("�ι�° ������ �߸� �Է��ϼż� 1�� �����մϴ�");
			}catch (Exception e) { // Exception�� �׻� ĳġ���� �Ʒ���
				System.out.println(e.getMessage());
			}
		System.out.printf("\n%d + %d = %d\n", i, j, (i+j));
		System.out.printf("\n%d - %d = %d\n", i, j, (i-j));
		System.out.print("\n��");
		sc.close();
	}
}
