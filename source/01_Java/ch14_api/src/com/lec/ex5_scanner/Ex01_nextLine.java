package com.lec.ex5_scanner;
// 1.����(nextInt) 2.�̸�(next) 3.�ּ�(nextLine)
//
import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ���: ");
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴� "+age+"��");
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = scanner.next();
		System.out.println("�Է��� �̸��� "+name+" �Դϴ�");
		System.out.print("�ּҸ� �Է��ϼ���: ");
		scanner.nextLine();
		// ���ۿ� �����ִ� "\n"�� ������ ��
		String address = scanner.nextLine(); // "\n"���� ���� return�ϰ� "\n" �ڴ� �����
		System.out.println("�Է��� �ּҴ� "+address);
		scanner.close();
	}
}
