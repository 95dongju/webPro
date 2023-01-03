package com.lec.ex1_square;

public class SquareMain {
	// 사실은 클래스 안에 데이터, 생성자, 메소드가 있음
	public static void main(String[] args) {
		 Square s1 = new Square(); // 쓰레기값에 new 해서 데이터를  .. 같은 패키지에서는 import 하지 않아도 됨. 다른 패키지에서는 import 필요
		 System.out.println("s1의 한변은 " +s1.getSide());
		 s1.setSide(2); // side의 데이터를 바꿈
		 System.out.println("수정된 s1의 넓이는 " +s1.area());
		 Square s2 = new Square(10); // 객체 생성 - 매개 변수 있음
		 System.out.println("s2의 한변은 "+s2.getSide());
		 System.out.println("s2의 넓이는 "+s2.area());
		 
	}
}
