package com.lec.ex11_store;

public class Store3 extends HeadQuarterStore {

	public Store3(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 6,000��");
	}
	@Override
	public void budae() {
		System.out.println("�δ�� : 7,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� : 7,000��");
	}
	@Override
	public void sundae() {
		System.out.println("��ū���뱹 : 6,000��");
	}
}
