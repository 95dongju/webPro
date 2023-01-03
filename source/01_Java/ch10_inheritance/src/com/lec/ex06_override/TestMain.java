package com.lec.ex06_override;

public class TestMain {
	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		System.out.println("--");
		Parent pObj2 = new Parent(10);
		System.out.println("--");
		System.out.println("pObj1과 pObj2가 같은지? " +pObj1.equals(pObj2));
		System.out.println("--");
		pObj1.method1();
		System.out.println("--");
		pObj2.method2();
		System.out.println("--");
		pObj1.method2();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		Child cObj1 = new Child(); // Parent() -> Child()
		System.out.println("--");
		Child cObj2 = new Child(2); // Parent() -> Child(2)
		System.out.println("--");
		cObj1.method1();
		System.out.println("--");
		cObj1.method2();
		System.out.println("--");
		cObj2.method3();
		// pObj1.method3(); //안됨 --> Parent에 method3이 없기 때문.
		System.out.println("--");
		System.out.println("cObj1과 pObj2가 같은지? " +cObj1.equals(pObj2));
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		//Child obj = new Child(); 아래와 같음.
		Parent obj = new Child();
		obj.method1();
		obj.method2();
		//obj.method3(); obj 변수의 타입 때문에 불가
		//((Child)obj).method3(); // 위험한 객체 형변환.
		if(obj instanceof Child) {
			((Child)obj).method3(); // 안전한 객체 형변환.
		}else {
			System.out.println("형변환 불가");
		}
	}
}
