package com.lec.ex09_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("ȫ�浿","010-8888-8888","����� ���빮��","12-01");
		System.out.println(customer.infoString());
		customer.buy(500000);
		customer.buy(510000);
		Staff staff = new Staff("ȫ���", "010-1111-1111", "2022-12-06", "�Ǹź�");
		Person[] person = {customer, staff};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		Person customer1 = new Customer("�ű⸮","010-1234-2345", "����� ��������", "12-07");
//		customer1.buy(20000);
		if (customer1 instanceof Customer) {
			((Customer)customer1).buy(20000);
		}else {
			System.out.println("buy�� �� ���� ��ü�Դϴ�");
		}
	}
	
}
