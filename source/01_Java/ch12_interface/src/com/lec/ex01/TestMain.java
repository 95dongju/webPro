package com.lec.ex01;

public class TestMain {	
	public static void main(String[] args) {
		InterfaceClass obj = new InterfaceClass();
		obj.method1();
		System.out.println(obj.method2());
		InterfaceEx1 obj1 = new InterfaceClass(); // interfaceClass �� ���� ���� InterfaceEx1, Ex2
		obj1.method1();
//		obj1.method2();
		InterfaceEx2 obj2 = new InterfaceClass();
		obj2.method2();
		System.out.println("��� CONSTANT_NUM : " +InterfaceEx1.CONSTANT_NUM);
		System.out.println("��� CONSTANT_NUM : " +InterfaceClass.CONSTANT_NUM);
		System.out.println("��� CONSTANT_NUM : " +obj.CONSTANT_NUM); // static�� class�� ���� ��õ, ��ü ���� �̸����� ���� ���������� ����
		System.out.println("��� CONSTANT_STRING : " +InterfaceEx2.CONSTANT_STRING);
		System.out.println("��� CONSTANT_STRING : " +obj.CONSTANT_STRING);
	}
}
		
		
//		InterfaceClass obj1 = new InterfaceClass(); //
//		InterfaceEx1 ex1 = new InterfaceEx1();
//		InterfaceEx2 ex2 = new InterfaceEx2() {
//			@Override
//			public String method2() {
//				System.out.println("�͸�Ŭ������ method2"); // �ȵ���̵忡���� ���� ������ �ڹٿ����� �͸�Ŭ���� ������ ����. ��ϸӽ� ��ü ������ ����
//				return null;
//			}
//		};
//		ex2.method2();
			