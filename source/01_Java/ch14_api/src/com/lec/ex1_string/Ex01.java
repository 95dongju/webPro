package com.lec.ex1_string;
// new 연산자를 사용하지 않고 " "를 사용한 문자열 상수는 heap 메모리 영역에 String 객체 생성됨
// 이미 존재하는 문자열 상수는 다시 사용됨 (새로 생성하지 않음)
// import 할 필요가 없음
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "java";	
		String str2 = "java"; //""를 사용한 문자열 상수는 heap메모리에 무조건 새로운 객체를 만들지 않고, heap메모리에 데이터가 있는지 찾음
		String str3 = new String("java"); // new 연산자를 사용한 String은 str1이랑 str2와 다른 새로운 객체
		if (str1==str2) {
			System.out.println("str1과 str2는 같은 주소를 참조");
		}else {
			System.out.println("str1과 str2는 다른 주소를 참조");
		}
		System.out.println(str1==str3 ? "str1과 str3는 같은 주소를 참조" : "str1과 str3는 다른 주소를 참조");
		str2 = "java~";
		System.out.println(str1==str2 ? "str1과 str2는 같은 주소를 참조" : "str1과 str2는 다른 주소를 참조");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
	}
}
