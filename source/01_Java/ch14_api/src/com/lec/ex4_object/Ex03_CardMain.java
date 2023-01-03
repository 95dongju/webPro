package com.lec.ex4_object;

import java.util.Random;

public class Ex03_CardMain { // ♥ ◆  ♣ ♠
	public static void main(String[] args) {
		Card[] cards = {new Card('♥', 1), new Card('♥', 2),
				new Card('♥', 3), new Card('♥', 4),
				new Card('♥', 5), new Card('♥', 6),
				new Card('♥', 7), new Card('♥', 8),
				new Card('♥', 9), new Card('♥', 10),
				new Card('♥', 11), new Card('♥', 12),
				new Card('♥', 13), new Card('♣', 10),};
		for(Card card : cards) { // 임시변수 : 배열변수
			System.out.println(card);
		} // for
		// 임의로 뽑힌 카드와 배열 안의 카드를 비교
		Random random = new Random(); // 시드를 정하면 난수를 동일하게 발생시킴
		char[] kinds = {'♥','◆' , '♣', '♠'};
		Card randomCard = new Card(kinds[random.nextInt(4)], random.nextInt(13)+1);
		System.out.println("임의로 뽑힌 카드: " +randomCard);
		// 중복된 것이 없을 것이라는 확신 (카드번호 등) 이 있으면 boolean 변수 안 씀
		// 변수는 중복된 것이 있을 때 (전화번호 뒷자리), 한번이라도 if문에서 출력을 할 경우, boolean을 false로 바꾸고 boolean 사용
		int idx;
		for (idx = 0 ; idx < cards.length ; idx++) {
			if(cards[idx].equals(randomCard)) {
				System.out.println(idx+1+"번째 카드와 일치함 * * * ");
				break; // 중복된 것이 없으면 한번 뿌리고 끝. 그렇기 때문에 break 사용.
			}
		} //for 
		// 중복된 카드가 없으면 for문 밖으로 나옴. idx가 card.length와 같으면 일치하는 카드가 없는 것임 / idx가 card.length와 다르면 일치하는 카드가 있는 것
		if (idx == cards.length) {
			System.out.println("일치하는 카드가 없습니다");
		}
	} //main
} //class
