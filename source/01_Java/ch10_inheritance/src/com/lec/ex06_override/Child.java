package com.lec.ex06_override;
// method1() , method2() �����ִ� ����
public class Child extends Parent {
	public Child() { // overloading
		System.out.println("�Ű����� ���� Child ������");
	}
	public Child(int i) {
		System.out.println("�Ű����� �ִ� Child ������");
	}
	@Override // ��ӹ��� ���� override ���� @ => �����Ϸ����� �˷��ִ� ��
	public void method1() { //override = �Լ��� ������ > Parent�� method1 �� ���� Child�� method1�� �� �Ŷ�� ������ �ϴ� ��
		System.out.println("Child�� method1()");
	}
	public void method3() {
		System.out.println("Child�� method3()");
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
}
