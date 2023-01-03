package strategy1.step5.modulazation;

// *은 interfaces 뒤의 모든 클래스 임포트 // ctrl + shift + o 필요한 것만 임포트

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	
	public LowRobot() {
		setFly(new FlyNo()); // fly = new FlyYes();
		setMissile(new MissileNo()); //missile = new MissileYes();
		setKnife (new KnifeNo()); //knife = new KnifeLazer();
	}
}
