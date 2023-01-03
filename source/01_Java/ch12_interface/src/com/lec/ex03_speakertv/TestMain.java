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
//		speaker.changeBatter(); // �������̽��� static �޼ҵ�� �Ʒ� Ŭ������ ���� �ȵ�.
		IVolume.changeBattery(); // �������̽��� �ִ� static �޼ҵ�� �������̽�.staticmethod �� ��� ����. �Ʒ��� ���� �Ұ�.
	}
}
