package com.lec.ex1_square;
// �Ӽ�, ������, �޼ҵ�, getter&setter (�ʿ��ϸ� ����, �ʿ������ �� ��. ���Ͱ� ������ �ش� �����ʹ� �����ڿ��� �ʱ�ȭ�ϰ� ��)
// Square s = new Square(); ..>������ --> ��ü ���� ���� �� ���� �����͸� ����ؼ� �޼ҵ�� ȣ���ϱ� ���� ����
// s�� side�� 0���� �ʱ�ȭ
// Square s1 = new Square(10); // s�� side�� 10���� �ʱ�ȭ�ϸ鼭 ��ü ����
public class Square {
	private int side; //�����ʹ� �����̺����� ���� (�Ϲ����� Ŭ��������) // ���������� ���� �ʿ�
	public Square() { //������ �Լ��� �ݵ�� public, ���� Ÿ�� ����, �ݵ�� Ŭ������� ������ �Լ�
		System.out.println("�Ű����� ���� ������ �Լ� ȣ��");
	}
	public Square(int side) { //�Ű������� �ִ� ������ �Լ��� ���� : private ������ �ʱ�ȭ
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ��");
	}
	public int area() {
		return side*side;
		
	}
	// setter: s1.setSide(5);
	public void setSide(int side) {
		this.side = side;
	}
	//getter: sysout(s1.getSide()) --> ȭ�鿡 �Ѹ� ��
	public int getSide() {
		return side;
	}
}


