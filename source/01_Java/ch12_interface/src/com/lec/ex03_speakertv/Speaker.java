package com.lec.ex03_speakertv;

public class Speaker implements IVolume {
	private int volumeLevel;
	private final int MAX_VOLUME = 50; // 해당 클래스에서만 사용할 상수는 상수 클래스 만들지 않고 해당 클래스에서 선언함.
	private final int MIN_VOLUME = 0;
	
	public Speaker() {
		volumeLevel = 10;
	}

	@Override
	public void volumeUp() { // 볼륨 1씩 증가
		if (volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("스피커 볼륨을 1 올려 현재 볼륨은 " +volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel+level < MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("스피커 볼륨을 "+level+" 올려 현재 볼륨은 " +volumeLevel);
		}else {
			int tempLevel = MAX_VOLUME - volumeLevel;
			volumeLevel = MAX_VOLUME;
			System.out.println("스피커 볼륨을 "+level+" 올려 최대치입니다");
		}
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > MIN_VOLUME) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1 내려 현재 볼륨은 " +volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최소치입니다.");
		}
		
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel-level > MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("스피커 볼륨을 "+level+" 내려 현재 볼륨은 " +volumeLevel);
		}else {
			int tempLevel = volumeLevel - MIN_VOLUME;
			volumeLevel = MIN_VOLUME;
			System.out.println("스피커 볼륨을 "+level+" 올려 최소치입니다");
		}
	}
}
