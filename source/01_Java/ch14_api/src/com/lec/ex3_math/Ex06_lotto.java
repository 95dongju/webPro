package com.lec.ex3_math;

import java.util.Random;

public class Ex06_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do {
				temp = random.nextInt(45)+1;
				for(j=0 ; j<i ; j++) {
					if(lotto[j] ==temp) {
						System.out.println("�ߺ��ż� �ٽ� ��" + temp);
						break;
					} //if - temp�� ���� ��ȣ�� ������ for���� ��������
				} //for
			}while(i!=j);
			lotto[i] = temp;
		}
		//�߻��� �ζ� ��ȣ ��� >> �ߺ��� ���� ������ �ߺ��� ���� �� ���� �ϴ� �� �÷��ǿ��� ���
 		for(int l : lotto) {
			System.out.print(l + "\t");
		}
 		System.out.println("\n���� ��");
 		//sort- lotto �迭 ���� ������� �����ϱ�
 		for(i=0 ; i<lotto.length-1 ; i++) {
 			
 			for(j=i+1 ; j<lotto.length ; j++) {
 				
 				// ���� �༭ �ٲٷ��� �ӽú����� �ʿ���
 				if(lotto[i] > lotto[j]) {
 					temp = lotto[i];
 					lotto[i] = lotto[j];
 					lotto[j] = temp;
 							
 				}
 			}
 		}
 		for(int l : lotto) {
			System.out.print(l + "\t");
 		}
	}
}
