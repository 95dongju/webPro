package com.lec.ex06;

public class PoohToy implements IMoveArmLeg {
	public PoohToy() {
		System.out.println("곰돌이 푸입니다");
		canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직을 수 있습니다");
	}

}
