package com.lec.ex4_product;

public class ProductMain {
	public static void main(String[] args) { // static�� �ּ��� �ִ� �� ����
//		Product p1 = new Product(); // �Ϲ� ������ �̷��� �ؾ� ����
		System.out.println(Product.count); // static�� Ŭ���� ���赵�� ���� ���� �ֱ� ������ import �ؼ� ��ü�� ������ �ʰ� ȣ���� ��.
		Product.staticMethod();
		Product p1 = new Product();
		p1.infoPrint();
//		System.out.println(p1.count); // p1���� product ��� ���� �� �� ����. static access �� ���� Ŭ�����̸�.access �ϴ� �� ����
		Product p2 = new Product();
		System.out.println("static ���� : "+Product.count);
		Product p3 = new Product();
		System.out.println("static ���� : "+p1.count);
		Product p4 = new Product();
		System.out.println("static ���� : "+p2.count);
		System.out.println("static ���� : "+p3.count);
	}
	
}
