package com.lec.ex12_account;

public class CheckingAccount extends Account {
	
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int amount) { // string은 ==로 하면 안됨, equals 사용해야 함
		if(this.cardNo.equals(cardNo)) { // 올바른 카드 번호 입력
			if(getBalance() >= amount) { // 중복 if문 > 잔액이 남아서 지불이 가능한지
				//balance = balance - amount;
				setBalance(getBalance() - amount); // 잔액 amount만큼 차감
				System.out.printf("%s님, %d원 지불하여 계좌(%s)에 잔액 %d원\n",getOwnerName(), amount, getAccountNo(), getBalance());
			}else { // 잔액 부족으로 지불 불가
				System.out.printf("%s님 계좌(%s)에 잔액이 부족하여 지불 불가합니다. 잔액: %d원\n", getOwnerName(), getAccountNo(), getBalance());
			}
		}else { // 틀린 카드 번호 입력
			System.out.println("유효한 카드 번호가 아닙니다.");
		}
	}//if문
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
