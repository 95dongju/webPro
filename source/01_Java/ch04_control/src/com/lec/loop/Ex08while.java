package com.lec.loop;

public class Ex08while {
	public static void main(String[] args) {
		int tot = 0; //������ ����
		int i=1;
		while(i<=10) {
			tot += i;
			System.out.printf("i�� %d�� ��, �������� %d�̴�\n", i, tot);
			i++;
			}
		
		// for��
//		for(int i=1 ; i<=10 ; i++) {
//			// ��� �� ���� �ʼ�! tot += i; //tot = tot i; (�ڹٴ� �̷��� �Ⱦ��ϴ�)
//			tot += i;
//			System.out.printf("i�� %d�� ��, �������� %d�̴�\n", i, tot);
//		}
	}
}
