package com.lec.ex02_store;
// 2ȣ��: ��ġ�-5,000 �δ��-5,000 �����-5,000 ���뱹-5,000  �����-����
public class Store2 implements HeadQuarterStore {
	
private String storeName;
	
	public Store2 (String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 5,000��");
	}

	@Override
	public void budae() {
		System.out.println("�δ�� : 5,000��");
	}

	@Override
	public void bibim() {
		System.out.println("����� : 5,000��");
	}

	@Override
	public void sundae() {
		System.out.println("���뱹 : 5,000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("�����: ����");
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	
}
