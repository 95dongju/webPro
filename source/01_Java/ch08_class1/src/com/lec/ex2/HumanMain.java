package com.lec.ex2;

import com.lec.ex2_human.*;
import com.lec.ex2_human.kid.Kid; 
//ex2_human.* : �޸� ��Ű�� �Ʒ��� �ִ� ��� Ŭ������ �� ���ڴٴ� ��
// ctrl shift o (���ʿ��� import �����ϴ� �뵵)

public class HumanMain {
	public static void main(String[] args) {
//		Man man = new Man(); 
//		// ������ �Լ��� �ϳ��� ����� default �����ڸ� �ڵ������� �� ����� ��.
//		Man kim = new Man("ȫ�浿", 22, 170, 65);
		Woman woman1 		= 		new Woman();
		Woman woman2 		= 		new Woman();
//	 ���۷��� ����(��ü����) ����      	��ü���� (�ν��Ͻ� ����)
		System.out.println("woman1�� woman2�� ������ : "+(woman1 == woman2)); 
		System.out.println("woman1�� woman2�� ������ : "+woman1.equals(woman2)); //��ü���� ���Ҷ��� equals �޼ҵ� ���
		// ������ �ʾƵ� �⺻������ ����� �� �ִ� �޼ҵ�(���)�� ����
		Man man = new Man();
		Kid kid1 = new Kid("�Ʊ�"); //�Ű����� �ִ� ������ �Լ��� ����� ���� ������ �Ű����� ���� ������ �Լ�(����Ʈ ������ �Լ�)�� �ڵ����� ��������� ����
		Man hong = new Man ("ȫ�浿");
		Man kim = new Man("��浿", 22, 180, 67); // 67�� ��� double�̶� 67.0�� ��.
		Man kim2 = kim;
		
		kim2.setHeight(185); kim2.setWeight(300);
		System.out.println("kim�� kim2�� ���� ��ü�ΰ� : "+kim.equals(kim2));
		System.out.println("kim�� kim2�� ���� ��ü�ΰ� : "+(kim == kim2));
		double bmi = kim.calculateBMI();
		System.out.println(kim2.getName()+"�� bmi ������ " +bmi);
	}
}

