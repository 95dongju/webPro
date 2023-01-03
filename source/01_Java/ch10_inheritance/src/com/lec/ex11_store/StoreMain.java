package com.lec.ex11_store;

public class StoreMain {
	public static void main(String[] args) {
//		HeadQuarterStore head = new HeadQuarterStore("= = 본사 = ="); // 이것도 아래처럼 배열로 만들 수 있지만,
//		Store1 st1 = new Store1("= = 주택가 1호점 = =");
//		Store2 st2 = new Store2("= = 대학가 2호점 = =");
//		Store3 st3 = new Store3("= = 증권가 3호점 = =");
//		System.out.println("---------------------------");
		
		HeadQuarterStore[] stores = {new HeadQuarterStore("= = 본사 = ="), 
				new Store1("= = 주택가 1호점 = ="), 
				new Store2("= = 대학가 2호점 = ="), 
				new Store3("= = 증권가 3호점 = =")}; // 배열을 추가할 수 없기 때문에 정해진 값에서만 사용하는 것이 좋음
	
//		System.out.println(head.getStoreName());
//		head.kimchi();
//		head.budae();
//		head.bibim();
//		head.sundae();
//		head.gonggibab(); 동일자료형 집합이기 때문에 아래처럼 배열로 처리할 수 있음
//		HeadQuarterStore[] stores = {head, st1, st2, st3};
		
		for(int idx=0 ; idx<stores.length ; idx++) { // idx는 length에 <=로 사용할 수 없음.
			System.out.println(stores[idx].getStoreName()); //배열 0방부터 끝까지 뿌려짐
			stores[idx].kimchi();
			stores[idx].budae();
			stores[idx].bibim();
			stores[idx].sundae();
			stores[idx].gonggibab();
		}// 일반 for문 > "반드시 3번째 인덱스가 나올 때마다 다음 줄을 출력해라"는 일반 for문 사용함
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
