package com.lec.ex01_parantchild;
// ParentClass 상속해서 pStr, getPapaName(), getMamiName(); 사용 가능
public class ChildClass extends ParentClass{
	String cStr = "자식클래스";
	public ChildClass() {
		System.out.println("자식 생성자");
	}
}
