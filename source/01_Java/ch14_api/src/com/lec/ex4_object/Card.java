package com.lec.ex4_object;
// new Card ('��', 6);
public class Card {
	private char kind; // �� ��  �� ��
	private int num; // 1 ~ 13
	
	public Card() {
	}
	
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "ī��: " +kind+ ", " +num;
	}
	
	@Override
	public boolean equals(Object obj) {
		// card.equals(comCard) ==> card = this / comCard = obj
		// obj != null && obj�� card Ÿ�� ��ü���� Ȯ�� �� kind, num �� ��� return

		
//		if (obj != null && obj instanceof Card) { // Ÿ���� ������ ����� �� instanceof
//			// kind�� num �� ��� return
//			return kind == ((Card)obj).kind & num == ((Card)obj).num;
//		}else {
//			return false;
//		}
		
		if (obj != null && getClass()==obj.getClass()) { //obj != null ��� ��
			Card other = (Card)obj; // ���Ǹ� ���� obj�� other�� ����ȯ
			boolean kindChk = kind == other.kind; // Kind�� String���� ������ kind.equals(other.kind) 
			boolean numChk = num == other.num;
			return kindChk && numChk;  // kind�� string�̸� equals�� ���ؾ� ��
		}else {
			return super.equals(obj);
		}
	}
}

