package com.lec.ex3_math;

import java.util.Random;

// 0 <= Math.random() < 1�� double ����
// 0 <= Math.random()*45 < 45
// 1 <= 				<= 45 / < 46 �̷��� �Ϸ���   1 <= (int)(Math.random()*45)+1 < 46
// Random random = new Random()
public class Ex03_Random {

	public static void main(String[] args) {
		System.out.println("1~45������ ���� ����: " +(int)(Math.random()*45)+1);
		Random random = new Random(); //�õ尪�� ���ϸ� ����� �Ȱ�����
		System.out.println("int ����: " +random.nextInt()); //���� ���� .nextInt()
		System.out.println("double ����: " +random.nextDouble()); //�Ǽ� ���� .nextDouble() = Math.random()�� ���� 0~1 �̸��� �Ǽ� ����
		System.out.println("true/false �� ����: " +random.nextBoolean()); //boolean ����
		System.out.println("0���� 100������ ���� ����: " +random.nextInt(101));
		System.out.println("0���� 44������ ���� ����: " +random.nextInt(45));
		System.out.println("0���� 45������ ���� ����: " +random.nextInt(46));
		System.out.println("0���� 45������ ���� ����: " +random.nextInt(46)+1); // 1�� ��Ʈ���� �Ǳ� ������ 40+1�� 401�� ��
		System.out.println("0���� 45������ ���� ����: " +(random.nextInt(46)+1)); // ��ȣ �ȿ� �־�� ��
		System.out.println("����(0), ����(1), ��(2) �� �ϳ� : " +random.nextInt(3));

	}
}
