package com.lec.ex4_newexception;
/* 데이터(속성): accountNo(String), ownerName(String), balance(long) 계좌번호는 바꾸면 안되기 때문에 setter 안 만듬
 * 기능 (메소드): deposit(예금), withdraw(인출), infoPrint(정보출력) */ 
public class Account {
	// 데이터 웬만하면 프라이빗
	private String accountNo;
	private String ownerName;
	private long balance;
	// 생성자
	public Account() {	
	}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance 알아서 0으로 초기화해서 들어감  balance = 0; 안 쳐도 됨
		System.out.println(ownerName+"님 계좌 개설 감사합니다. 잔액 : "+balance+" 원");
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"님 계좌 개설 감사합니다. 잔액 : "+balance+" 원");
	}
	//메소드 무조건 퍼블릭, 리턴 타입 없으면 void
	public void deposit(long money) {//예금 (무조건 가능)
		balance += money; 
		System.out.println(money+" 원 예금하여 잔액 :"+balance+" 원");
	}

	public void withdraw(long money) throws Exception { 
		if(balance>=money) {
			balance -= money;
			System.out.println(money+" 원 인출하여 잔액 :"+balance+" 원");
		}else {
			throw new Exception("★잔액이 부족하여 인출 불가합니다★");
		}
	}
	public void infoPrint() {
		// "110-302-4928" 홍길동님 잔액 : 10원 출력
		System.out.println("\""+accountNo+"\" "+ownerName+"님 잔액 : "+balance+"원");
		System.out.printf("\"%s\" %s 님 잔액: %d원\n", accountNo, ownerName, balance);
	}
	public String infoString() {
		//	return "\""+accountNo+"\" "+ownerName+"님 잔액 : "+balance+"원";
	return String.format("\"%s\" %s 님 잔액: %d원\n", accountNo, ownerName, balance);
		}
		
	// setter : 오직 name에만 세팅 (계좌번호 바뀔 일 없음. 잔액도 외부에서 바꾸면 안되기 때문)
	// getter : accountNo, ownerName, balance
	public String getAccountNo() {
		return accountNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
