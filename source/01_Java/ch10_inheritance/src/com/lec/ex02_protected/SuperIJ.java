package com.lec.ex02_protected;

public class SuperIJ {
	protected int i; // private�̸� �ڽ� Ŭ�������� access �� �� �ݵ�� get, set ����ؾ� ������, protected �ϸ� �ڽ� Ŭ�������� �����Ӱ� ��� ����
	protected int j;
	public SuperIJ() { //������ �Լ��� Ŭ���� ��� ����, ���� Ÿ�� ���� //��ӹ��� Ŭ�������� �θ� Ŭ������ ����Ʈ �����ڰ� ȣ�� (�⺻������)
		System.out.println("�Ű����� ���� SuperIJ ������ �Լ�");
	}
	public SuperIJ(int i, int j) {
		System.out.println("�Ű����� �ִ� SuperIJ, ������ �Լ��� i, j�� �ʱ�ȭ");
		this.i = i; // i 0���� �ʱ�ȭ
		this.j = j; // j 0���� �ʱ�ȭ
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
