package com.lec.ex5;
// Child child1 = new Child("ù°");
// Child1.takeMoney(1000);
public class Child {
	private String name; // null�� ��
//	MomPouch momPouch; // null�� �� --> �̷��� �Ǹ� ���� ���� ��ü�� ����Ǳ� ������ �������� �ʾƼ� 2000���� �����.
	static MomPouch momPouch; //--> �̷��� �ؾ� ���� ������ static���� �����ϱ� ������ ���� ���� ������.
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
		
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"�� "+money+"�� �������� ���� ������ "+momPouch.money);
		}else {
			System.out.println(name+"�� �� �� ����. ���� ���� ������ " +momPouch.money);
		}
	}
}
