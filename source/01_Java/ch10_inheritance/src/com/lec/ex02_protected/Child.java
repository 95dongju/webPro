package com.lec.ex02_protected;
//private i, j / public setI(), getI(), setJ(), getJ()
public class Child extends SuperIJ {
	private int total;
	public Child() {
		super();
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i, int j) { // super�� �̿��ؼ� ����
		super(i,j);
		System.out.println("�Ű����� �ִ� child ������ �Լ� - i, j �ʱ�ȭ");
		
	}
	public void sum() {
		total = getI()+getJ(); 
		total = i + j;// private�� ���� �ȵ�, protected�� ��� ����
		System.out.println("i = " +getI() + ", j = " +getJ() + ", total = "+total);
	}
}
