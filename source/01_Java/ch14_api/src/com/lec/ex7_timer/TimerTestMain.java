package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // 프로그램 종료가 timer가 메모리 상주하지 않음, true를 안 넣으면 timer가 계속 구동함
		TimerTask task1 = new TimerTaskEx1(); //2초 후 1번
		TimerTask task2 = new TimerTaskEx2(); //
		timer.schedule(task1, 2000); //초는 millisec, 2초 후 실행
		timer.schedule(task2, 1000, 500); // 1초 후 0.5초마다 실행
		Thread.sleep(11000); //11초 멈춤
		System.out.println("끝");
	}
}
