package com.lec.ex11_store;
// 1ȣ��: �δ��-5,000��, ���뱹-X
public class Store1 extends HeadQuarterStore {
	
	public Store1(String storeName) {
		super(storeName);
	}
	@Override
	public void budae() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void sundae() {
		System.out.println("���뱹 �� �˴ϴ�");
	}
}
