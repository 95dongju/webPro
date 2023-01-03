package com.lex.ex5_atm;

public class ATMTarget implements Runnable {
	private ATM atm;
	private boolean flag; // 처음에는 false
	
	public ATMTarget(ATM atm) {
		this.atm = atm;
	}

	@Override
	public void run() {
		for(int i=0; i<10 ; i++) {
			if(flag) {
				atm.withdraw(1000, Thread.currentThread().getName());
				flag = false;
			}else {
				atm.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
	}

}
