package com.lec.ex06;

public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("�����");
		canLight();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canLight() {
		System.out.println("�Һ��� �ݻ��� �� �ֽ��ϴ�");

	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �߻��� �� �ֽ��ϴ�");
	}

}
