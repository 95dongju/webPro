package com.lec.ex1_square;

public class SquareMain {
	// ����� Ŭ���� �ȿ� ������, ������, �޼ҵ尡 ����
	public static void main(String[] args) {
		 Square s1 = new Square(); // �����Ⱚ�� new �ؼ� �����͸�  .. ���� ��Ű�������� import ���� �ʾƵ� ��. �ٸ� ��Ű�������� import �ʿ�
		 System.out.println("s1�� �Ѻ��� " +s1.getSide());
		 s1.setSide(2); // side�� �����͸� �ٲ�
		 System.out.println("������ s1�� ���̴� " +s1.area());
		 Square s2 = new Square(10); // ��ü ���� - �Ű� ���� ����
		 System.out.println("s2�� �Ѻ��� "+s2.getSide());
		 System.out.println("s2�� ���̴� "+s2.area());
		 
	}
}
