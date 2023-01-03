package strategy1.step5.modulazation;

// *은 interfaces 뒤의 모든 클래스 임포트 // ctrl + shift + o 필요한 것만 임포트
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
