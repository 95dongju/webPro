package com.lec.ex09_customer;

import cons.Constant;

public class Customer extends Person {
	private String 	address;
	private int 	sum; // 구매금액 누적
	private int 	point; // 포인트 적립 (구매시 0.5% 적립)
	private String 	date;	
	private boolean vip; // true면 vip, false면 일반 고객
	// Customer c = new Customer ("홍길동", "010-0000-0000", "서울 관악구", "12-08") 구매 금액 누적 변수, 포인트는 따로 넣어야 함 (고객이 바꾸면 안되는 정보)

	public Customer (String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name+"님 가입 감사합니다. 포인트 1000점을 드렸습니다");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price; // 구매금액에 누적
		int tempPoint = (int)(price * Constant.RATE); // 포인트 얼마 충전?
		point += tempPoint; // 포인트 누적
		System.out.println(getName()+"님 감사합니다. 금번 포인트 = " + tempPoint);
		System.out.println("누적 포인트 = " + point);
		if(vip == false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName()+"님 VIP 고객으로 업그레이드 되셨습니다");
		}//if
	}//buy
	@Override
	public String infoString() {
		return super.infoString() + "\t[주소]" + address + "\t [포인트]" +point;
	}
}//class

