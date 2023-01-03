package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // A sObj = new S(); 안됨. 자식이 부모를 가르키는 것 불가능. // 생성자함수 1개 실행
		A aObj = new A(); // == S aObj = new A(); // 생성자 함수 2개 실행 (부모+자식단)
		B bObj = new B(); // == S bObj = new B(); // 생성자 함수 2개 실행 (부모+자식단)
		C cObj = new C(); // == S cObj = new C(); // 생성자 함수 2개 실행 (부모+자식단)
		// 객체는 ==가 아니라 aObj.equals(bObj)로 사용함
//		System.out.println("aObj와 bObj가 같냐? = " + aObj.equals(bObj));
//		S[] arr = {new S(), new A(), new B(), new C()}; // 타입 일치 시키기
		S[] arr = {sObj, aObj, bObj, cObj};
		for(S a : arr) {
			System.out.println("s= "+a.s);
		}
	}
}
