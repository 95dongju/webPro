package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // A sObj = new S(); �ȵ�. �ڽ��� �θ� ����Ű�� �� �Ұ���. // �������Լ� 1�� ����
		A aObj = new A(); // == S aObj = new A(); // ������ �Լ� 2�� ���� (�θ�+�ڽĴ�)
		B bObj = new B(); // == S bObj = new B(); // ������ �Լ� 2�� ���� (�θ�+�ڽĴ�)
		C cObj = new C(); // == S cObj = new C(); // ������ �Լ� 2�� ���� (�θ�+�ڽĴ�)
		// ��ü�� ==�� �ƴ϶� aObj.equals(bObj)�� �����
//		System.out.println("aObj�� bObj�� ����? = " + aObj.equals(bObj));
//		S[] arr = {new S(), new A(), new B(), new C()}; // Ÿ�� ��ġ ��Ű��
		S[] arr = {sObj, aObj, bObj, cObj};
		for(S a : arr) {
			System.out.println("s= "+a.s);
		}
	}
}
