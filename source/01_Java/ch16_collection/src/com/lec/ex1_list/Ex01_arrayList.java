package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3]; // 배열을 선언하면 값을 바꿀 수 없음 
		array[0] = "str0"; array[1] = "str1"; array[2] = "str2";
		for(String arr : array) {
			System.out.println(arr);
		}
		for(int i=0 ; i<array.length ; i++) {
			System.out.println(i+"번 인덱스 값은 : " +array[i]);
		}
		System.out.println("--------- Array List ----------");
		ArrayList<String> arrayList = new ArrayList<String>();// String arraylist (String밖에 안 들어옴) object 넣으면 정수, 스트링, 다 들어옴 Integer 넣으면 정수만
		System.out.println("현재 arrayList 사이즈는 " +arrayList.size()); //.size도 많이 나옴 (size가 0이면 요청하신 상품이 없습니다)
		arrayList.add("str0"); // 0번 인덱스, add를 할 때마다 데이터 추가됨
		arrayList.add("str1"); // 1번 인덱스 --> 21번 줄에서 add해서 2번 인덱스가 됨
		arrayList.add("str2"); // 2번 인덱스 --> 21번 줄에서 add해서 3번 인덱스가 됨
		arrayList.add(1,"111111"); // 1번 인덱스
		System.out.println("현재 arrayList 사이즈는 " +arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "-----"); //1번 인덱스 값을 수정
		for(String temp : arrayList) {
			System.out.println(temp);
		}
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.println(idx+"번 인덱스 값은 : " +arrayList.get(idx));
		}
		arrayList.remove(1); // 1번 인덱스 제거
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스 값 제거
		System.out.println("1번 인덱스와 마지막 인덱스 제거 후 " +arrayList);
		arrayList.clear(); // arrayList 모든 데이터를 제거
		System.out.println(arrayList.isEmpty()? "arrayList 사이즈가 0" : "arrayList 사이즈가 0이 아님");
		System.out.println("모든 데이터 제거 후 " +arrayList);
		// arrayList = null; // arrayList에 null을 할당 --> nullPointException 발생
	}
}
