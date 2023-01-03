package strategy1.step5.modulazation;

// *�� interfaces ���� ��� Ŭ���� ����Ʈ // ctrl + shift + o �ʿ��� �͸� ����Ʈ

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
