package com.lec.ex3_accesstest;

public class AccessTest {
	private int privateMember;	// ���� Ŭ���� �������� ��� ���� --> �ܺο��� ����Ϸ��� ���� & ����
	protected int protectedMember; // ���� ��Ű���� ��� ���� Ŭ�������� ��� ����
	int defaultMember; // default (��������) ���� ��Ű�� �������� ��� ����
	public int publicMember; // �ƹ������� ��� ����
	private void privateMethod() {
		System.out.println("private �޼ҵ� - �ܺο��� access �Ұ���, �� Ŭ���������� ��� ���� (getter&setter �ʿ�)");
	}
	protected void protectedMethod() {
		System.out.println("protected �޼ҵ� - ���� ��Ű���� ��ӹ��� Ŭ�������� ��� ����");
	}
	void defaultMethod() {
		System.out.println("default �޼ҵ�");
	}
	public void publicMethod() {
		System.out.println("public �޼ҵ�");
	}
}
