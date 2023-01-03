package com.lec.ex4_object;

import java.util.Random;

public class Ex03_CardMain { // �� ��  �� ��
	public static void main(String[] args) {
		Card[] cards = {new Card('��', 1), new Card('��', 2),
				new Card('��', 3), new Card('��', 4),
				new Card('��', 5), new Card('��', 6),
				new Card('��', 7), new Card('��', 8),
				new Card('��', 9), new Card('��', 10),
				new Card('��', 11), new Card('��', 12),
				new Card('��', 13), new Card('��', 10),};
		for(Card card : cards) { // �ӽú��� : �迭����
			System.out.println(card);
		} // for
		// ���Ƿ� ���� ī��� �迭 ���� ī�带 ��
		Random random = new Random(); // �õ带 ���ϸ� ������ �����ϰ� �߻���Ŵ
		char[] kinds = {'��','��' , '��', '��'};
		Card randomCard = new Card(kinds[random.nextInt(4)], random.nextInt(13)+1);
		System.out.println("���Ƿ� ���� ī��: " +randomCard);
		// �ߺ��� ���� ���� ���̶�� Ȯ�� (ī���ȣ ��) �� ������ boolean ���� �� ��
		// ������ �ߺ��� ���� ���� �� (��ȭ��ȣ ���ڸ�), �ѹ��̶� if������ ����� �� ���, boolean�� false�� �ٲٰ� boolean ���
		int idx;
		for (idx = 0 ; idx < cards.length ; idx++) {
			if(cards[idx].equals(randomCard)) {
				System.out.println(idx+1+"��° ī��� ��ġ�� * * * ");
				break; // �ߺ��� ���� ������ �ѹ� �Ѹ��� ��. �׷��� ������ break ���.
			}
		} //for 
		// �ߺ��� ī�尡 ������ for�� ������ ����. idx�� card.length�� ������ ��ġ�ϴ� ī�尡 ���� ���� / idx�� card.length�� �ٸ��� ��ġ�ϴ� ī�尡 �ִ� ��
		if (idx == cards.length) {
			System.out.println("��ġ�ϴ� ī�尡 �����ϴ�");
		}
	} //main
} //class
