package com.lec.ex4_newexception;

public class AccountMain {

	public static void main(String[] args) {
		Account a1 = new Account("111-1111", "ȫ�浿");
		a1.deposit(10000);
		try {
			a1.withdraw(12000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
