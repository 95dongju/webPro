package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new A()); // 0�� �ε����� A�� ��ü�� ���� (toString ȣ���)
		vec.add(new B()); // 1�� �ε����� B�� ��ü�� ���� (toString ȣ���)
		vec.add("Hello, Collection"); // 2�� �ε����� ��Ʈ�� (������Ʈ�⿡ ����)
		vec.add(10); // vec.add(new Integer(10)); ���� �ڵ����� �ٲ� ��
		System.out.println(vec);
	}
}
