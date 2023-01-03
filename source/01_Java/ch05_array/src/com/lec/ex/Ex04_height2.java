package com.lec.ex;

import java.util.Scanner;

// ����, ö��, �浿, ����, ������ Ű�� �Է¹ް�, ���ġ�� ���ϱ�
// ���� ū �л��� ���� ���� �л�
public class Ex04_height2 {
	public static void main(String[] args) {
		String[] arrName = {"����", "ö��","�浿", "����", "����"};
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totHeight = 0;
		// ������� Ű �Է� �ޱ� > totHeight�� �����ؾ� ��
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű�� ? : ");
			arrHeight[idx] = sc.nextInt();
			totHeight += arrHeight[idx]; // ���� = ��հ� ���� ���ؼ� 
		}
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.printf("%d��° %s�� Ű�� %d\n", idx, arrName[idx], arrHeight[idx]);
		}
		System.out.println("���Ű�� " +(double)totHeight/(double)arrHeight.length);
		sc.close();
		int maxIdx=0, maxHeight=0;  // ������� ���ϱ� ���� ������ (���������� �ʱ�ȭ)
		int minIdx=0, minHeight=9999; // �ִܽ��� ���ϱ� ���� ������(ū������ �ʱ�ȭ)
		for(int idx=0 ; idx<arrName.length ; idx++) {
			if(arrHeight[idx] > maxHeight) {
				maxHeight = arrHeight[idx];
				maxIdx = idx;
			} //if max
			if(arrHeight[idx] < minHeight) {
				minHeight = arrHeight[idx];
				minIdx = idx;
			} //if min
		} //for
		System.out.printf("���� ū ����� %s, %d cm\n", arrName[maxIdx], maxHeight);
		System.out.printf("���� ���� ����� %s, %d cm\n", arrName[minIdx], minHeight);
	} //main
} //class
