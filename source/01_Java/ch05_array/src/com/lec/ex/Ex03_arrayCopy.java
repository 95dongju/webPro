package com.lec.ex;
// �迭 ����
public class Ex03_arrayCopy {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
		System.arraycopy(score, 0, s, 0, score.length); // �˾Ƽ� ī���ϴ� ���
		// int[] s = score; xxxx ���� �ƴ� . s�� ������ ������ �ϱ� ������ new�� �޸� Ȯ�� �ʿ���.
		//�Ʒ��� ���� ����� ���� System.arraycopy(� �� ī��?, ������?, ���� ī��?, ������?, ���̴�?)
//		int[] s = new int[score.length]; //5�� �ϸ� �ȵ�. score ���� �����ϱ� ������ score.length ���� Ȯ�� �ʿ�.
//		for(int idx=0 ; idx<s.length ; idx++) {
//			s[idx] = score[idx];
//		}
		s[0] = 999;
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.printf("score[%d] = %d\t / s[%d] = %d\n", idx, score[idx], idx, s[idx]);
		}
	}
}

