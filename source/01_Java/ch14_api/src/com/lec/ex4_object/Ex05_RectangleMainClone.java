package com.lec.ex4_object;

public class Ex05_RectangleMainClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(); // r1:w=0, h=0, color="검정"
		r1.setHeight(5); r1.setWidth(10); // w=10, h=5, color="검정"
		Rectangle r2 = (Rectangle) r1.clone(); // 주소 복사 new Rectangle(10,5,"검정")
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " + r2); // 복제가 아니라 같은 주소를 가르키는 것임
		if(r1.equals(r2)) {
			System.out.println("r1과 r2는 같은 내용의 사각형 객체 (복제를 한 건지 복사를 한 건지?)"); // = 같은 주소이기 때문에 해당 내용으로 나옴
		}else {
			System.out.println("r1과 r2는 다른 내용의 사각형 객체");
		}
		if(r1==r2) {
			System.out.println("복제한 게 아니고 복사한 것");
		}else {
			System.out.println("다른 주소");
		}
		if(r1!=r2 && r1.equals(r2)) { // 복제라 함은 r1과 r2가 다른 주소여야 함. 복제는 주소를 복사한 것이 아니라 다른 주소로 동일한 내용을 가짐.
			System.out.println("복제 성공");
		} else {
			System.out.println("복제 실패");
		}
	}
}
