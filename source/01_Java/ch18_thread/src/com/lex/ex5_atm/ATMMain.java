package com.lex.ex5_atm;

public class ATMMain {
	public static void main(String[] args) {
		ATM atm = new ATM(1000);
		Runnable card = new ATMTarget(atm);
		Thread t1 = new Thread(card, "����");
		t1.start();
		Thread t2 = new Thread(card, "�ƺ�");
		t2.start();
	}
}
