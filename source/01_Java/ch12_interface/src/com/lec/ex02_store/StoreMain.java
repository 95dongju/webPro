package com.lec.ex02_store;

public class StoreMain {
	public static void main(String[] args) {

		HeadQuarterStore[] stores = {
				//new HeadQuarterStore("= = ���� = ="), �߻�Ŭ������ ��ü�� ������ �� ����
				new Store1("= = 1ȣ�� = ="), 
				new Store2("= = 2ȣ�� = ="), 
				new Store3("= = 3ȣ�� = =")}; 
		
		for(int idx=0 ; idx<stores.length ; idx++) {
			System.out.println(stores[idx].getStoreName()); 
			stores[idx].kimchi();
			stores[idx].budae();
			stores[idx].bibim();
			stores[idx].sundae();
			stores[idx].gonggibab();
		}// �Ϲ� for��
		for(HeadQuarterStore store : stores) {
			System.out.println(store.getStoreName());;
			store.kimchi();
			store.budae();
			store.bibim();
			store.sundae();
			store.gonggibab();
		}// Ȯ�� for��
		
	}//main
	
}//class
