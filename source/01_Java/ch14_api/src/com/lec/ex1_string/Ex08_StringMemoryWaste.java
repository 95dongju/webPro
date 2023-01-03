package com.lec.ex1_string;

public class Ex08_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, Java";
		//str의 주소 출력이 안됨 -> 해쉬코드로 대체
		System.out.println("str의 해쉬코드 : " +str.hashCode());
		str = "hello";
		System.out.println("str의 수정 후 해쉬코드 : " +str.hashCode());
		// 스트링은 메모리 낭비가 생기기 때문에 String Buffer로 대체 -> 속도를 빠르게 함
	}
}
