package com.lec.ex4_product;

public class Product {
	private int serialNo; // 객체 고유의 번호
	public static int count = 100; // static 변수 = 클래스 변수 = 공유 변수 (다른 객체 변수와 공유하는 변수)
	public Product() {	
		serialNo = count++;
	}
	public void infoPrint() {
		System.out.println("시리얼 넘버: " +serialNo + "\t공유변수 count : " +count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public static void staticMethod() { // 메소드 앞에 붙인 static 테스트
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
