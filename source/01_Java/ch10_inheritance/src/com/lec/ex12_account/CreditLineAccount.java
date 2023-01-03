package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount {
	
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { // cardNo는 super단에 있기 때문에 get으로 가져와야 함
			if(creditLine >= amount) { // 한도랑 비교
				//creditLine = balance - amount;
				creditLine -= amount;
				System.out.printf("%s님, %d원 지불하여 한도 %d원 남았습니다\n",getOwnerName(), amount, creditLine);
			}else { // 한도 부족으로 지불 불가
				System.out.printf("%s님, 카드 한도 지불 불가합니다\n", getOwnerName());
			}
		}else { // 틀린 카드 번호 입력
			System.out.println("유효한 카드 번호가 아닙니다.");
		}
	}
}

