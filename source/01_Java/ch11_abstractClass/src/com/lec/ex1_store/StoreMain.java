package com.lec.ex1_store;

public class StoreMain {
	public static void main(String[] args) {

		HeadQuarterStore[] stores = {
				//new HeadQuarterStore("= = ���� = ="), �߻�Ŭ������ ��ü�� ������ �� ����
				new Store1("= = ���ð� 1ȣ�� = ="), 
				new Store2("= = ���а� 2ȣ�� = ="), 
				new Store3("= = ���ǰ� 3ȣ�� = =")}; 
		
		for(int idx=0 ; idx<stores.length ; idx++) {
			System.out.println(stores[idx].getStoreName()); 
			stores[idx].kimchi();
			stores[idx].budae();
			stores[idx].bibim();
			stores[idx].sundae();
			stores[idx].gonggibab();
		}// �Ϲ� for��
		for(HeadQuarterStore store : stores) {
			System.out.println(store);
			store.kimchi();
			store.budae();
			store.bibim();
			store.sundae();
			store.gonggibab();
		}// Ȯ�� for��
		
	}//main
}//class
