package com.lec.ex10_final;
// speed, running(), stop(final)
public final class Rabbit extends Animal {
	@Override
	public void running() {
		speed += 30;
		System.out.println("토끼가 마구마구 뛰어요. 현재 속도 : " + speed);
	}
}
