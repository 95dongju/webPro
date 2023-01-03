package com.lec.ex06_override;
// method1() , method2() 들어와있는 상태
public class Child extends Parent {
	public Child() { // overloading
		System.out.println("매개변수 없는 Child 생성자");
	}
	public Child(int i) {
		System.out.println("매개변수 있는 Child 생성자");
	}
	@Override // 상속받은 것은 override 가능 @ => 컴파일러에게 알려주는 것
	public void method1() { //override = 함수의 재정의 > Parent의 method1 안 쓰고 Child의 method1를 쓸 거라고 재정의 하는 것
		System.out.println("Child의 method1()");
	}
	public void method3() {
		System.out.println("Child의 method3()");
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
}
