package strategy1.step5.modulazation;

// *�� interfaces ���� ��� Ŭ���� ����Ʈ // ctrl + shift + o �ʿ��� �͸� ����Ʈ
import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {
	
	public SuperRobot() {
		setFly(new FlyYes()); // fly = new FlyYes();
		setMissile(new MissileYes()); //missile = new MissileYes();
		setKnife (new KnifeLazer()); //knife = new KnifeLazer();
	}
	
}
