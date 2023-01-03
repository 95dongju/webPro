package com.lec.ex02_store;

public class Store3 implements HeadQuarterStore {
	
	private String storeName;
	
	public Store3 (String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 6,000¿ø");
	}

	@Override
	public void budae() {
		System.out.println("ºÎ´ëÂî°³ : 7,000¿ø");
	}

	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 7,000¿ø");
	}

	@Override
	public void sundae() {
		System.out.println("¼ø´ë±¹ : 6,000¿ø");
	}

	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä: 1,000¿ø");
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
