package com.lec.ex5_personinfo;

public class PersonInfoTestMain {
	public static void main(String[] args) {
//		int i = 10;
//		int[] arr = {1,2,3};
//		for(int idx=0 ; idx<arr.length ; idx++) {
//			System.out.println(arr[idx]);
//		}
//		for(int a : arr) { // Ȯ�� for��
//			System.out.println(a);
//		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		PersonInfo p1 = new PersonInfo("ȫ", 32, 'f');
//		PersonInfo[] person = { new PersonInfo("ȫ�浿", 25, 'm'),
//								new PersonInfo("ȫ���", 25, 'f')};
		
		PersonInfo[] person = new PersonInfo[2]; // person�� �ִ� ���� �迭�� ����
		person[0] = p1;
		person[1] = new PersonInfo("ȫ���", 25, 'f');
		
		for(int idx=0 ; idx<person.length ; idx++) {
			// person[idx].print();
			System.out.println(person[idx].infoString());
		}
		for(PersonInfo p : person) {
			System.out.println(p.infoString());
		}
	}
}
