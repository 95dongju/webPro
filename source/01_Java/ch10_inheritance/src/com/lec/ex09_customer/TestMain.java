package com.lec.ex09_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍길동","010-8888-8888","서울시 서대문구","12-01");
		System.out.println(customer.infoString());
		customer.buy(500000);
		customer.buy(510000);
		Staff staff = new Staff("홍사원", "010-1111-1111", "2022-12-06", "판매부");
		Person[] person = {customer, staff};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		Person customer1 = new Customer("신기리","010-1234-2345", "서울시 영등포구", "12-07");
//		customer1.buy(20000);
		if (customer1 instanceof Customer) {
			((Customer)customer1).buy(20000);
		}else {
			System.out.println("buy할 수 없는 객체입니다");
		}
	}
	
}
