package com.lec.ex3;

import com.lec.ex3_accesstest.AccessTest;

public class AccessTestMain2 {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember); --> private�̶� ���� ��
//		System.out.println(obj.protectedMember); --> �ٸ� ��Ű���� ������
//		System.out.println(obj.defaultMember); --> �ٸ� ��Ű���� ������
		System.out.println(obj.publicMember);
//		obj.privateMethod(); --> private�̶� �ȵ�
//		obj.protectedMethod();--> �ٸ� ��Ű���� ������
//		obj.defaultMethod();--> �ٸ� ��Ű���� ������
		obj.publicMethod();		// �ܺο��� ������ public
	}
}
