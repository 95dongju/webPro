package com.lec.loop;

public class Ex05_breakContinue {
	public static void main(String[] args) {
		for(int i = 1 ; 1<=5 ; i++) {
			if(i==3) 
				// break; // �ݺ��� ���� ��������
				continue; // �ݺ��� ���� ������ �ö󰡼� ������ (����� 3 ���� ��µ�)
			System.out.print(i);
			System.out.println("\t");
		}
	}
}
