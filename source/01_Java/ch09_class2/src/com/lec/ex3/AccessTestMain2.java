package com.lec.ex3;

import com.lec.ex3_accesstest.AccessTest;

public class AccessTestMain2 {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember); --> private이라 에러 남
//		System.out.println(obj.protectedMember); --> 다른 패키지라 에러남
//		System.out.println(obj.defaultMember); --> 다른 패키지라 에러남
		System.out.println(obj.publicMember);
//		obj.privateMethod(); --> private이라 안됨
//		obj.protectedMethod();--> 다른 패키지라 에러남
//		obj.defaultMethod();--> 다른 패키지라 에러남
		obj.publicMethod();		// 외부에서 쓰려면 public
	}
}
