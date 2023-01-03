package com.lec.ex1_square;
// 속성, 생성자, 메소드, getter&setter (필요하면 쓰고, 필요없으면 안 씀. 세터가 없으면 해당 데이터는 생성자에서 초기화하고 끝)
// Square s = new Square(); ..>생성자 --> 객체 변수 만들어서 그 안의 데이터를 사용해서 메소드로 호출하기 위해 만듬
// s의 side는 0으로 초기화
// Square s1 = new Square(10); // s의 side를 10으로 초기화하면서 객체 생성
public class Square {
	private int side; //데이터는 프라이빗으로 세팅 (일반적인 클래스에서) // 습관적으로 생성 필요
	public Square() { //생성자 함수는 반드시 public, 리턴 타입 없음, 반드시 클래스명과 동일한 함수
		System.out.println("매개변수 없는 생성자 함수 호출");
	}
	public Square(int side) { //매개변수가 있는 생성자 함수의 역할 : private 데이터 초기화
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출");
	}
	public int area() {
		return side*side;
		
	}
	// setter: s1.setSide(5);
	public void setSide(int side) {
		this.side = side;
	}
	//getter: sysout(s1.getSide()) --> 화면에 뿌릴 때
	public int getSide() {
		return side;
	}
}


