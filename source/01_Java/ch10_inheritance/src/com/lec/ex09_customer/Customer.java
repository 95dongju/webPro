package com.lec.ex09_customer;

import cons.Constant;

public class Customer extends Person {
	private String 	address;
	private int 	sum; // ���űݾ� ����
	private int 	point; // ����Ʈ ���� (���Ž� 0.5% ����)
	private String 	date;	
	private boolean vip; // true�� vip, false�� �Ϲ� ��
	// Customer c = new Customer ("ȫ�浿", "010-0000-0000", "���� ���Ǳ�", "12-08") ���� �ݾ� ���� ����, ����Ʈ�� ���� �־�� �� (���� �ٲٸ� �ȵǴ� ����)

	public Customer (String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name+"�� ���� �����մϴ�. ����Ʈ 1000���� ��Ƚ��ϴ�");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price; // ���űݾ׿� ����
		int tempPoint = (int)(price * Constant.RATE); // ����Ʈ �� ����?
		point += tempPoint; // ����Ʈ ����
		System.out.println(getName()+"�� �����մϴ�. �ݹ� ����Ʈ = " + tempPoint);
		System.out.println("���� ����Ʈ = " + point);
		if(vip == false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName()+"�� VIP ������ ���׷��̵� �Ǽ̽��ϴ�");
		}//if
	}//buy
	@Override
	public String infoString() {
		return super.infoString() + "\t[�ּ�]" + address + "\t [����Ʈ]" +point;
	}
}//class

