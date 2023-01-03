package com.lec.ex12_account;

public class AccountMain {

	public static void main(String[] args) {
		Account a1 = new Account("111-1111", "È«±æµ¿");
		CheckingAccount a2 = new CheckingAccount("222-2222", "¼ºÃáÇâ", 2000, "1111-2222-3333-4444");
		CheckingAccount a3 = new CreditLineAccount("333-3333", "ÀÌ¸ù·æ", 2000, "5555-6666-7777-8888", 10000);
		a1.deposit(10000);
		a1.withdraw(10000);
		a2.pay("1111-2222-3333-4444", 10000);
		a3.pay("1111-2222-3333-4444", 10000);
	}

}
