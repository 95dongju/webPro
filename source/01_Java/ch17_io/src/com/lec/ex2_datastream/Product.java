package com.lec.ex2_datastream;
// 필요한 변수는 위에 선언함
public class Product {
	private String name;
	private int price;
	private int stock;
	
	public Product() {
	}
	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return name + "\t" + price + "원\t" + stock + "개\t";
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
