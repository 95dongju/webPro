package com.lec.ex1_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		// ������ ���� ��� String ���� �����
		
		StringBuffer strBuffer = new StringBuffer ("abc");
		System.out.println("strBuffer�� �ؽ��ڵ� : " +strBuffer.hashCode());
		
		strBuffer.append("def");
		System.out.println("append �� :" +strBuffer);
		
		System.out.println("strBuffer�� ������ �ؽ��ڵ� : " +strBuffer.hashCode());
		// String�� �ؽ��ڵ尡 �ٲ�. ������ StringBuffer�� �����ص� �ؽ��ڵ尡 �ٲ��� ����.
		
		
		strBuffer.insert(3,"aaa"); //3��°�� aaa �߰�
		System.out.println("insert ��: " +strBuffer);
		
		strBuffer.delete(3, 6); // 3��°���� 6��° �ձ���
		System.out.println("delete ��: " +strBuffer);
		
		int capacitySize = strBuffer.capacity(); // ������ ����ũ��
		System.out.println("������ ����ũ���: " +capacitySize);
		
		strBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789");
		System.out.println("append ��: " +strBuffer);
		
		int capacitySize2 = strBuffer.capacity();
		System.out.println("������ ����ũ���: " +capacitySize2);
		System.out.println("�ؽ��ڵ� : " +strBuffer.hashCode());
	}
}
