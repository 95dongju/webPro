package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3]; // �迭�� �����ϸ� ���� �ٲ� �� ���� 
		array[0] = "str0"; array[1] = "str1"; array[2] = "str2";
		for(String arr : array) {
			System.out.println(arr);
		}
		for(int i=0 ; i<array.length ; i++) {
			System.out.println(i+"�� �ε��� ���� : " +array[i]);
		}
		System.out.println("--------- Array List ----------");
		ArrayList<String> arrayList = new ArrayList<String>();// String arraylist (String�ۿ� �� ����) object ������ ����, ��Ʈ��, �� ���� Integer ������ ������
		System.out.println("���� arrayList ������� " +arrayList.size()); //.size�� ���� ���� (size�� 0�̸� ��û�Ͻ� ��ǰ�� �����ϴ�)
		arrayList.add("str0"); // 0�� �ε���, add�� �� ������ ������ �߰���
		arrayList.add("str1"); // 1�� �ε��� --> 21�� �ٿ��� add�ؼ� 2�� �ε����� ��
		arrayList.add("str2"); // 2�� �ε��� --> 21�� �ٿ��� add�ؼ� 3�� �ε����� ��
		arrayList.add(1,"111111"); // 1�� �ε���
		System.out.println("���� arrayList ������� " +arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "-----"); //1�� �ε��� ���� ����
		for(String temp : arrayList) {
			System.out.println(temp);
		}
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.println(idx+"�� �ε��� ���� : " +arrayList.get(idx));
		}
		arrayList.remove(1); // 1�� �ε��� ����
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� �� ����
		System.out.println("1�� �ε����� ������ �ε��� ���� �� " +arrayList);
		arrayList.clear(); // arrayList ��� �����͸� ����
		System.out.println(arrayList.isEmpty()? "arrayList ����� 0" : "arrayList ����� 0�� �ƴ�");
		System.out.println("��� ������ ���� �� " +arrayList);
		// arrayList = null; // arrayList�� null�� �Ҵ� --> nullPointException �߻�
	}
}
