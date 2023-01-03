package com.lec.ex4_object;
// new Card ('♥', 6);
public class Card {
	private char kind; // ♥ ◆  ♣ ♠
	private int num; // 1 ~ 13
	
	public Card() {
	}
	
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "카드: " +kind+ ", " +num;
	}
	
	@Override
	public boolean equals(Object obj) {
		// card.equals(comCard) ==> card = this / comCard = obj
		// obj != null && obj가 card 타입 객체인지 확인 후 kind, num 비교 결과 return

		
//		if (obj != null && obj instanceof Card) { // 타입이 같은지 물어보는 것 instanceof
//			// kind와 num 비교 결과 return
//			return kind == ((Card)obj).kind & num == ((Card)obj).num;
//		}else {
//			return false;
//		}
		
		if (obj != null && getClass()==obj.getClass()) { //obj != null 없어도 됨
			Card other = (Card)obj; // 편의를 위해 obj를 other로 형변환
			boolean kindChk = kind == other.kind; // Kind를 String으로 쓰려면 kind.equals(other.kind) 
			boolean numChk = num == other.num;
			return kindChk && numChk;  // kind가 string이면 equals로 비교해야 함
		}else {
			return super.equals(obj);
		}
	}
}

