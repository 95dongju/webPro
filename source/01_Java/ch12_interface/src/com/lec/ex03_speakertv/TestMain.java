package com.lec.ex03_speakertv;

public class TestMain {
	public static void main(String[] args) {
		IVolume speaker = new Speaker();
		IVolume tv 		= new TV();
		IVolume[] devices = {speaker, tv};
		for(IVolume device : devices) {
			device.volumeDown();
			device.volumeDown(50);
			device.volumeUp();
			device.setMute(true);
			device.setMute(false);
		}
		speaker.setMute(false);
//		speaker.changeBatter(); // 인터페이스의 static 메소드는 아래 클래스로 전달 안됨.
		IVolume.changeBattery(); // 인터페이스에 있는 static 메소드는 인터페이스.staticmethod 로 사용 가능. 아래로 전달 불가.
	}
}
