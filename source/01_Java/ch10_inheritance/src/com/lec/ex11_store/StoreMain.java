package com.lec.ex11_store;

public class StoreMain {
	public static void main(String[] args) {
//		HeadQuarterStore head = new HeadQuarterStore("= = ���� = ="); // �̰͵� �Ʒ�ó�� �迭�� ���� �� ������,
//		Store1 st1 = new Store1("= = ���ð� 1ȣ�� = =");
//		Store2 st2 = new Store2("= = ���а� 2ȣ�� = =");
//		Store3 st3 = new Store3("= = ���ǰ� 3ȣ�� = =");
//		System.out.println("---------------------------");
		
		HeadQuarterStore[] stores = {new HeadQuarterStore("= = ���� = ="), 
				new Store1("= = ���ð� 1ȣ�� = ="), 
				new Store2("= = ���а� 2ȣ�� = ="), 
				new Store3("= = ���ǰ� 3ȣ�� = =")}; // �迭�� �߰��� �� ���� ������ ������ �������� ����ϴ� ���� ����
	
//		System.out.println(head.getStoreName());
//		head.kimchi();
//		head.budae();
//		head.bibim();
//		head.sundae();
//		head.gonggibab(); �����ڷ��� �����̱� ������ �Ʒ�ó�� �迭�� ó���� �� ����
//		HeadQuarterStore[] stores = {head, st1, st2, st3};
		
		for(int idx=0 ; idx<stores.length ; idx++) { // idx�� length�� <=�� ����� �� ����.
			System.out.println(stores[idx].getStoreName()); //�迭 0����� ������ �ѷ���
			stores[idx].kimchi();
			stores[idx].budae();
			stores[idx].bibim();
			stores[idx].sundae();
			stores[idx].gonggibab();
		}// �Ϲ� for�� > "�ݵ�� 3��° �ε����� ���� ������ ���� ���� ����ض�"�� �Ϲ� for�� �����
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
