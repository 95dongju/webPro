package com.lec.ex1_store;
// �߻�Ŭ������ �ϳ� �̻��� �߻� �޼ҵ带 ������ �־�� ��. 
// �߻�Ŭ�����δ� ��ü�� ���� �� ������, �ݵ�� ����ؼ� ����� ����� ����.
public abstract class HeadQuarterStore { 
	private String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	// �߻�޼ҵ� : ���� ����� Ŭ�������� �ݵ�� override �϶�� ��.
	//			 �޼ҵ� ���� ���� ��, ������ ����.
	public abstract void kimchi();
	public abstract void budae();
	public abstract void bibim();
	public abstract void sundae();
	public abstract void gonggibab();
	
	public String getStoreName() {
		return storeName;
	}
}

