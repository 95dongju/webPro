package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new A()); // 0번 인덱스에 A형 객체를 참조 (toString 호출됨)
		vec.add(new B()); // 1번 인덱스에 B형 객체를 참조 (toString 호출됨)
		vec.add("Hello, Collection"); // 2번 인덱스에 스트링 (오브젝트기에 가능)
		vec.add(10); // vec.add(new Integer(10)); 으로 자동으로 바뀌어서 들어감
		System.out.println(vec);
	}
}
