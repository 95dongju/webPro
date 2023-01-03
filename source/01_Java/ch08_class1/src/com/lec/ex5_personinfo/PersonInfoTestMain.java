package com.lec.ex5_personinfo;

public class PersonInfoTestMain {
	public static void main(String[] args) {
//		int i = 10;
//		int[] arr = {1,2,3};
//		for(int idx=0 ; idx<arr.length ; idx++) {
//			System.out.println(arr[idx]);
//		}
//		for(int a : arr) { // 확장 for문
//			System.out.println(a);
//		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		PersonInfo p1 = new PersonInfo("홍", 32, 'f');
//		PersonInfo[] person = { new PersonInfo("홍길동", 25, 'm'),
//								new PersonInfo("홍길순", 25, 'f')};
		
		PersonInfo[] person = new PersonInfo[2]; // person이 있는 곳에 배열이 있음
		person[0] = p1;
		person[1] = new PersonInfo("홍길순", 25, 'f');
		
		for(int idx=0 ; idx<person.length ; idx++) {
			// person[idx].print();
			System.out.println(person[idx].infoString());
		}
		for(PersonInfo p : person) {
			System.out.println(p.infoString());
		}
	}
}
