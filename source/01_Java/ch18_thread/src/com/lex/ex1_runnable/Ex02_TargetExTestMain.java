package com.lex.ex1_runnable;

public class Ex02_TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01 (); //안녕하세요 10
		Runnable target02 = new TargetEx02 (); //반갑습니다 20
		//"A"라는 이름의 쓰레드 생성 - 안녕하세요 10
		Thread threadA = new Thread(target01);
		threadA.setName("A");
		//쓰레드 생성 (이름은 자동 생성) - 반갑습니다 20
		Thread threadB = new Thread(target02);
		threadA.start();
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("나는 " +Thread.currentThread().getName()+"의 i = " +i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
