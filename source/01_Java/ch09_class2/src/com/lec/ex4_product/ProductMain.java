package com.lec.ex4_product;

public class ProductMain {
	public static void main(String[] args) { // static은 최소한 있는 게 좋음
//		Product p1 = new Product(); // 일반 변수는 이렇게 해야 잡힘
		System.out.println(Product.count); // static은 클래스 설계도랑 같이 잡혀 있기 때문에 import 해서 객체를 만들지 않고도 호출이 됨.
		Product.staticMethod();
		Product p1 = new Product();
		p1.infoPrint();
//		System.out.println(p1.count); // p1보다 product 라고 쓰는 게 더 좋음. static access 할 때는 클래스이름.access 하는 게 좋음
		Product p2 = new Product();
		System.out.println("static 변수 : "+Product.count);
		Product p3 = new Product();
		System.out.println("static 변수 : "+p1.count);
		Product p4 = new Product();
		System.out.println("static 변수 : "+p2.count);
		System.out.println("static 변수 : "+p3.count);
	}
	
}
