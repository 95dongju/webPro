package com.lec.ex02_store;
// 추상클래스는 하나 이상의 추상 메소드를 가지고 있어야 함. 
// 추상클래스로는 객체를 만들 수 없으며, 반드시 상속해서 쓰라고 만드는 것임.
public interface HeadQuarterStore { 
	
	public void kimchi();
	public void budae();
	public void bibim();
	public void sundae();
	public void gonggibab();
	public String getStoreName();
}

