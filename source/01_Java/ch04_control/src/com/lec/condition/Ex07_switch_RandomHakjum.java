package com.lec.condition;

import java.util.Scanner;
//�����Ҷ����� ��ǻ�Ͱ� �������� (�������ھ�) �߻��Ͽ� ���� ���
public class Ex07_switch_RandomHakjum {
	public static void main(String[] args) {
//		System.out.println((int)(Math.random()*100)); 
		// ���� �߻���Ű�� �Լ� (�Ǽ�) (0 <= Math.random() < 1) (�Ǽ�)
		// 0 <= Math.ramdom()*100 < 100 = 0���� 100 �̸��� �Ǽ��� �߻��� (�Ǽ�)
		// ******************************************************************
		// ����ȯ (int) ����ϸ� ������ ��ȯ��
		// ******* 0 <= ((int)(Math.ramdom()*101)) < 101 = 0���� 101 �̸��� ������ �߻��� *********
		int score = ((int)(Math.random()*101)); 
		int temp = (score==100) ? score-1 : score; // score/10���� ������ 101 �Է½� a������ ����. �׷��� ������ temp(�ӽ�)���� 100 �̻��� �Ǵ�Ex04_if_hakjum.java
		switch(temp/10) {
		case 9:
			System.out.println(score + "= A����");break;
		case 8:
			System.out.println(score + "= B����");break;
		case 7:
			System.out.println(score + "= C����");break;
		case 6:
			System.out.println(score + "= D����");break;
		case 5: case 4: case 3: case 2: case 1:
			System.out.println(score + "= F����");break;
		default:
			System.out.println(score + "= ��ȿ���� �ʴ� �����Դϴ�");
//		}
		}
	}
}

