package com.lec.ex11_store;
// 1호점: 부대찌개-5,000원, 순대국-X
public class Store1 extends HeadQuarterStore {
	
	public Store1(String storeName) {
		super(storeName);
	}
	@Override
	public void budae() {
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void sundae() {
		System.out.println("순대국 안 팝니다");
	}
}
