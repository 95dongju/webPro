package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {
// TimerTask는 추상클래스이기 때문에 반드시 상속받아야 함

	@Override
	public void run() { // 작업정의
		System.out.println("~ ~ ~ 작업2 : 1초 후에 0.5초마다 수행될 예정인 TimerTask ~ ~ ~");
	}
}
