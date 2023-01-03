package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

// add를 할 때는 arrayList가 빠름
// remove로 인덱스 변경할 경우 linkedList가 빠름
public class Ex02_LinkedList {
	public static void main(String[] args) {
		ArrayList<String> object = new ArrayList<String> (); // arrayList 쓰는 법
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println(linkedList.isEmpty()); // 데이터를 넣은 적이 없어서 true로 뜸
		System.out.println(linkedList.size()); // 데이터를 넣은 적이 없어서 0이 나옴
		linkedList.add("str0"); //0번 인덱스
		linkedList.add("str1"); //1번 인덱스 -> 0
		linkedList.add("str2"); //2번 인덱스 -> 1
		linkedList.remove("str0"); //특정 지을 수 있음 remove 잘못하면 시간을 엄청 소요함 (위에서 다 바꿔야 하기 때문)
		if (linkedList.size()==0) {
			System.out.println("데이터가 없습니다.");
		}else {
			for(int i=0; i<linkedList.size(); i++) {
				System.out.println(i+" : " +linkedList.get(i));
			}
		}
		linkedList.clear();
		if (linkedList.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}else {
			for(String temp : linkedList) {
				System.out.println(temp);
			}
		}
	}
}
