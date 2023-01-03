package com.lec.ex4_object;

public class Ex02_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9812122981272L); //소수점이 없으면 기본적으로 int로 인식함. 즉 뒤에 L을 넣어야함.
		Person p2 = new Person(9812122981272L);
		Person p3 = null;
		Friend f = new Friend();
		System.out.println(p1.equals(p2) ? "p1 = p2" : "p1 != p2");
		System.out.println(p1==p2? "p1 = p2 (주소)" : "p1 != p2 (주소)");
//		System.out.println(p1.equals(p3) ? "p1 = p3" : "p1 != p3");
//		System.out.println(p1.equals(f) ? "p1 = f" : "p1 != f");
	}	
}
