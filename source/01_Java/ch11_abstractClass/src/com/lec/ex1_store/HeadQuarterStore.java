package com.lec.ex1_store;
// 추상클래스는 하나 이상의 추상 메소드를 가지고 있어야 함. 
// 추상클래스로는 객체를 만들 수 없으며, 반드시 상속해서 쓰라고 만드는 것임.
public abstract class HeadQuarterStore { 
	private String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	// 추상메소드 : 나를 상속한 클래스에서 반드시 override 하라는 뜻.
	//			 메소드 선언만 있을 뿐, 구현은 없다.
	public abstract void kimchi();
	public abstract void budae();
	public abstract void bibim();
	public abstract void sundae();
	public abstract void gonggibab();
	
	public String getStoreName() {
		return storeName;
	}
}

