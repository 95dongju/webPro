package com.lec.ex6_wrapper;
// Wrapper Ŭ����: Integer, Double, Long, Boolean... ���ʵ����͸� ��ü�����ͷ� ��ȯ�� Ŭ����
public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // ���ʵ����� Ÿ��
		//Integer iObj = new Integer (10); // ��ü������ Ÿ�� // new Integer(10) object �� 10 ������ �ڵ����� Integer ��ü ������
		Integer iObj = 10; // ��ü�̱� ������ �����Ǵ� method�� ����
		int sum = i+iObj;
		//int sum = i+iObj.intValue(); 
		//iObj�� ��ü�̱� ������ ������ �ȵ�����, iObj�� iObj.intValue(); �� �����ϱ� ������ �˾Ƽ� �ٲ�.
		System.out.println("���� "+sum);
		System.out.println(iObj.equals(10)); // ���� ������ true�� ��ȯ
		
	}
}
