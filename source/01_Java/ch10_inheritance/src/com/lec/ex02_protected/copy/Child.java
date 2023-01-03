package com.lec.ex02_protected.copy;
//private i, j / public setI(), getI(), setJ(), getJ()
public class Child extends SuperIJ {
	private int total;
	public Child() {
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) {
		System.out.println("매개변수 있는 child 생성자 함수 - i, j 초기화");
//		setI(i);//
		this.i=i; //부모의 private이면 한번에 access 불가능 (set 통해서 access 가능)
//		setJ(j);//
		this.j=j;
	}
	public void sum() {
		total = getI()+getJ(); 
		total = i + j;// private일 때는 안됨, protected면 사용 가능
		System.out.println("i = " +getI() + ", j = " +getJ() + ", total = "+total);
	}
}
