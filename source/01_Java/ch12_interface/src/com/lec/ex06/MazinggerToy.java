package com.lec.ex06;

public class MazinggerToy implements IMissile, IMoveArmLeg {
	public MazinggerToy() {
		System.out.println("마징가입니다");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있습니다");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 발사할 수 있습니다");
	}

}
