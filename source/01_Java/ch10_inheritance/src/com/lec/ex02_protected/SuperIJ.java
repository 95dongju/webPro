package com.lec.ex02_protected;

public class SuperIJ {
	protected int i; // private이면 자식 클래스에서 access 할 때 반드시 get, set 사용해야 하지만, protected 하면 자식 클래스에서 자유롭게 사용 가능
	protected int j;
	public SuperIJ() { //생성자 함수는 클래스 명과 동일, 리턴 타입 없음 //상속받은 클래스에서 부모 클래스의 디폴트 생성자가 호출 (기본적으로)
		System.out.println("매개변수 없는 SuperIJ 생성자 함수");
	}
	public SuperIJ(int i, int j) {
		System.out.println("매개변수 있는 SuperIJ, 생성자 함수로 i, j값 초기화");
		this.i = i; // i 0으로 초기화
		this.j = j; // j 0으로 초기화
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}
