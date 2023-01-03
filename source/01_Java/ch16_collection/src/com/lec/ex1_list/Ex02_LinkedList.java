package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

// add�� �� ���� arrayList�� ����
// remove�� �ε��� ������ ��� linkedList�� ����
public class Ex02_LinkedList {
	public static void main(String[] args) {
		ArrayList<String> object = new ArrayList<String> (); // arrayList ���� ��
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println(linkedList.isEmpty()); // �����͸� ���� ���� ��� true�� ��
		System.out.println(linkedList.size()); // �����͸� ���� ���� ��� 0�� ����
		linkedList.add("str0"); //0�� �ε���
		linkedList.add("str1"); //1�� �ε��� -> 0
		linkedList.add("str2"); //2�� �ε��� -> 1
		linkedList.remove("str0"); //Ư�� ���� �� ���� remove �߸��ϸ� �ð��� ��û �ҿ��� (������ �� �ٲ�� �ϱ� ����)
		if (linkedList.size()==0) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}else {
			for(int i=0; i<linkedList.size(); i++) {
				System.out.println(i+" : " +linkedList.get(i));
			}
		}
		linkedList.clear();
		if (linkedList.isEmpty()) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}else {
			for(String temp : linkedList) {
				System.out.println(temp);
			}
		}
	}
}
