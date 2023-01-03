package com.lec.ex03_speakertv;
// 인터페이스 - static final 변수(상수)와 추상메소드만 올 수 있다 > 업데이트 되면서 default라고 하면 메소드 넣을 수 잇음
// 작업명세서 역할을 한다
public interface IVolume {
	public void volumeUp(); // 볼륨 레벨 1씩 up
	public void volumeUp(int level); // 볼륨 레벨을 level씩 up
	public void volumeDown(); // 볼륨 레벨을 1씩 down
	public void volumeDown(int level); // 볼륨 레벨을 level씩 down
	public default void setMute(boolean mute) { // 디폴트 메소드
		if(mute) {
			System.out.println("무음");
		}else {
			System.out.println("무음 해제");
		}
	}
	public static void changeBattery() { //static 메소드
		System.out.println("건전지를 교환합니다");
	}
}
