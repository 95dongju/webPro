package com.lec.ex2;

public class TestMain {
	public static void main(String[] args) {
//		SuperClass super = new SuperClass; // ��ü�� ���� �� ����
//		SuperClass obj; // ������ ���� �� ����
		SuperClass obj2 = new ChildClass(); // Ÿ�����θ� ����
		obj2.method1();
		obj2.method2();
		obj2.method3();
		
// �߸��� ����
		SuperClass nope = new SuperClass() {
			public void method1() {
				System.out.println("�͸�Ŭ������ method1");
			}
		};
		obj2.method1();
		nope.method1();
		nope.method2();
		nope.method3(); // �̸� ���� Ŭ������. �ȵ���̵忡���� ����������, �ڹٿ����� �ȵ�.
	}
}
