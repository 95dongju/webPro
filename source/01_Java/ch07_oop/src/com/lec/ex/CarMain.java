package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); //new�� ����� ���� 0���� �ʱ�ȭ�Ǿ�����.
		//myPorsche.color = "������";
		myPorsche.setColor("����");
		System.out.println(myPorsche.getColor()+"���� ��ⷮ: " + myPorsche.getCc());
		myPorsche.drive();
		System.out.println(myPorsche.getColor()+"���� �ӵ�: " + myPorsche.getSpeed());
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		//yourPorsche.color = "�Ķ���";
		yourPorsche.setColor("�Ķ�");
		yourPorsche.drive();
		System.out.println("�� �� �ӵ��� "+myPorsche.getSpeed());
	}
}
