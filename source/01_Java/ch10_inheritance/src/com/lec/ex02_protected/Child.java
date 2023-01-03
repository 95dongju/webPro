package com.lec.ex02_protected;
//private i, j / public setI(), getI(), setJ(), getJ()
public class Child extends SuperIJ {
	private int total;
	public Child() {
		super();
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) { // super를 이용해서 수정
		super(i,j);
		System.out.println("매개변수 있는 child 생성자 함수 - i, j 초기화");
		
	}
	public void sum() {
		total = getI()+getJ(); 
		total = i + j;// private일 때는 안됨, protected면 사용 가능
		System.out.println("i = " +getI() + ", j = " +getJ() + ", total = "+total);
	}
}
