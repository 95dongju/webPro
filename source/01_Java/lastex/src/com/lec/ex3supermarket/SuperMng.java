package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMng {
	public static void main(String[] args) {
		CustomerDAO dao = CustomerDAO.getInstance();
		Scanner sc = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDTO> customers;
		do {
			System.out.print("1: ȸ������, 2:��ȭ��ȣ �˻�, 3: ��ǰ����, 4: ���������, 5: ��ü���, 6: Ż��, �׿ܴ� ����");
			fn = sc.next();
			switch(fn) {
			case "1": 
				System.out.print("������ ȸ�� �̸�:");
				String cname = sc.next();
				System.out.print("������ ȸ�� ��ȣ:");
				String ctel = sc.next();
//				int result = dao.insertCustomer(ctel, cname);
				int result = dao.insertCustomer(new CustomerDTO(cname, ctel));
				System.out.println(result==CustomerDAO.SUCCESS? cname+"�� ȸ������ �����մϴ�. ����Ʈ 1000��." : "ȸ������ ����");
				break;
			case "2":
				System.out.print("�˻��� ��ȭ��ȣ: ");
				String searchTel = sc.next();
				customers = dao.ctelGetCustomers(searchTel);
				if(customers.isEmpty()) {
					System.out.println(searchTel+" ��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ�������ϼ���.");
				} else {
					System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
					for (CustomerDTO customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3":
				System.out.print("�����̵� (�����̵� �� ���, �˻�) :");
				int cid = sc.nextInt();
				System.out.print("��ǰ����: ");
				int price = sc.nextInt();
				result = dao.buy(cid, price);
				if (result==CustomerDAO.SUCCESS) {
					System.out.println("��ǰ���� �����մϴ�"+price+"�� �����Ͽ� ������ �����Ͱ� �Ʒ��� ���� �Ǿ����ϴ�");
					CustomerDTO customer = dao.getCustomer(cid);
					System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
					System.out.println(customer);
				} else {
					System.out.println(cid+"�� ��ȿ�� �� ���̵� �ƴմϴ�");
				}
				break;
			case "4":
				System.out.print("�˻��� ���� " +dao.getLevelNames() +" �Է��ϼ��� : ");
				String levelName = sc.next();
				customers = dao.levelNameGetCustomers(levelName);
				if(customers.size()==0) {
					System.out.println("�ش� ���� ("+levelName+")�� ���� �˻����� �ʽ��ϴ�");
				} else {
					System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
					for (CustomerDTO customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "5":
				customers = dao.getCustomer();
				if(customers.size()==0) {
					System.out.println("���� �����ϴ�");
				} else {
					System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
					for (CustomerDTO customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6":
				System.out.print("Ż���� �� ��ȭ��ȣ�� �Է��ϼ��� : ");
				ctel = sc.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDAO.SUCCESS? "ȸ�� Ż�� ����" : "��ȿ�� ��ȭ��ȣ�� �ƴմϴ�");
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6"));
		System.out.println("BYE");
	}
}
