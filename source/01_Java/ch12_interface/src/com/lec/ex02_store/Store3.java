package com.lec.ex02_store;

public class Store3 implements HeadQuarterStore {
	
	private String storeName;
	
	public Store3 (String storeName) {
		this.storeName = storeName;
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
		System.out.println("���뱹 : 6,000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("�����: 1,000��");
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
