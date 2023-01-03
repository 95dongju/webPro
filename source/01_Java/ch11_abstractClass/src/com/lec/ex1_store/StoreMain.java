package com.lec.ex1_store;

public class StoreMain {
	public static void main(String[] args) {

		HeadQuarterStore[] stores = {
				//new HeadQuarterStore("= = 본사 = ="), 추상클래스는 객체를 생성할 수 없음
				new Store1("= = 주택가 1호점 = ="), 
				new Store2("= = 대학가 2호점 = ="), 
				new Store3("= = 증권가 3호점 = =")}; 
		
		for(int idx=0 ; idx<stores.length ; idx++) {
			System.out.println(stores[idx].getStoreName()); 
			stores[idx].kimchi();
			stores[idx].budae();
			stores[idx].bibim();
			stores[idx].sundae();
			stores[idx].gonggibab();
		}// 일반 for문
		for(HeadQuarterStore store : stores) {
			System.out.println(store);
			store.kimchi();
			store.budae();
			store.bibim();
			store.sundae();
			store.gonggibab();
		}// 확장 for문
		
	}//main
}//class
