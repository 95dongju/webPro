package com.lec.ex11_store;
// ���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
// HeadQuarterStore head = new HeadQuarterStore ( " = = ���� = = ");
public class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("��ġ� : 5,000��");
	}
	public void budae() {
		System.out.println("�δ�� : 6,000��");
	}
	public void bibim() {
		System.out.println("����� : 6,000��");
	}
	public void sundae() {
		System.out.println("���뱹 : 5,000��");
	}
	public void gonggibab() {
		System.out.println("����� : 1,000��");
	}
	public String getStoreName() {
		return storeName;
	}
}

