package strategy1.step4.modulazation;

// *은 interfaces 뒤의 모든 클래스 임포트 // ctrl + shift + o 필요한 것만 임포트
import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	private FlyImpl	 	fly;
	private MissileImpl missile;
	private KnifeImpl	knife;
	
	public LowRobot() {
		setFly(new FlyNo()); // fly = new FlyYes();
		setMissile(new MissileNo()); //missile = new MissileYes();
		setKnife (new KnifeNo()); //knife = new KnifeLazer();
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}
	// setter 필요

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}

}
