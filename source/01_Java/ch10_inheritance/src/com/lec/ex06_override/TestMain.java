package com.lec.ex06_override;

public class TestMain {
	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		System.out.println("--");
		Parent pObj2 = new Parent(10);
		System.out.println("--");
		System.out.println("pObj1�� pObj2�� ������? " +pObj1.equals(pObj2));
		System.out.println("--");
		pObj1.method1();
		System.out.println("--");
		pObj2.method2();
		System.out.println("--");
		pObj1.method2();
		System.out.println("�������������������������������������������");
		Child cObj1 = new Child(); // Parent() -> Child()
		System.out.println("--");
		Child cObj2 = new Child(2); // Parent() -> Child(2)
		System.out.println("--");
		cObj1.method1();
		System.out.println("--");
		cObj1.method2();
		System.out.println("--");
		cObj2.method3();
		// pObj1.method3(); //�ȵ� --> Parent�� method3�� ���� ����.
		System.out.println("--");
		System.out.println("cObj1�� pObj2�� ������? " +cObj1.equals(pObj2));
		System.out.println("�������������������������������������������");
		//Child obj = new Child(); �Ʒ��� ����.
		Parent obj = new Child();
		obj.method1();
		obj.method2();
		//obj.method3(); obj ������ Ÿ�� ������ �Ұ�
		//((Child)obj).method3(); // ������ ��ü ����ȯ.
		if(obj instanceof Child) {
			((Child)obj).method3(); // ������ ��ü ����ȯ.
		}else {
			System.out.println("����ȯ �Ұ�");
		}
	}
}
