package com.lec.ex1_string;
// new �����ڸ� ������� �ʰ� " "�� ����� ���ڿ� ����� heap �޸� ������ String ��ü ������
// �̹� �����ϴ� ���ڿ� ����� �ٽ� ���� (���� �������� ����)
// import �� �ʿ䰡 ����
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "java";	
		String str2 = "java"; //""�� ����� ���ڿ� ����� heap�޸𸮿� ������ ���ο� ��ü�� ������ �ʰ�, heap�޸𸮿� �����Ͱ� �ִ��� ã��
		String str3 = new String("java"); // new �����ڸ� ����� String�� str1�̶� str2�� �ٸ� ���ο� ��ü
		if (str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҸ� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҸ� ����");
		}
		System.out.println(str1==str3 ? "str1�� str3�� ���� �ּҸ� ����" : "str1�� str3�� �ٸ� �ּҸ� ����");
		str2 = "java~";
		System.out.println(str1==str2 ? "str1�� str2�� ���� �ּҸ� ����" : "str1�� str2�� �ٸ� �ּҸ� ����");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
	}
}
