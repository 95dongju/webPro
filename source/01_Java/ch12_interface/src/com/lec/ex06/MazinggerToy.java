package com.lec.ex06;

public class MazinggerToy implements IMissile, IMoveArmLeg {
	public MazinggerToy() {
		System.out.println("��¡���Դϴ�");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �߻��� �� �ֽ��ϴ�");
	}

}
