package com.lec.ex4_product;

public class Product {
	private int serialNo; // ��ü ������ ��ȣ
	public static int count = 100; // static ���� = Ŭ���� ���� = ���� ���� (�ٸ� ��ü ������ �����ϴ� ����)
	public Product() {	
		serialNo = count++;
	}
	public void infoPrint() {
		System.out.println("�ø��� �ѹ�: " +serialNo + "\t�������� count : " +count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public static void staticMethod() { // �޼ҵ� �տ� ���� static �׽�Ʈ
		System.out.println("static method test");
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Product.count = count;
	}
}
