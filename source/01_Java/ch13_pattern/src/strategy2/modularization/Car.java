package strategy2.modularization;

import strategy2.interfaces.EngineImpl;
import strategy2.interfaces.FuelImpl;
import strategy2.interfaces.KmImpl;
// super Ŭ����
public abstract class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;
	
	public void drive() {
		System.out.println("����̺� �� �� �ֽ��ϴ�");
	}
	public abstract void shape();
	
	public void isEngine() {
		engine.engine();
	}
	public void isKmPerLiter() {
		km.kmPerLiter();
	}
	public void isFuel() {
		fuel.fuel();
	}
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setKm(KmImpl km) {
		this.km = km;
	}
	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
}
