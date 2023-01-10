package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDAO dao = CustomerDAO.getInstance();
		int result;
		ArrayList<CustomerDTO> customers;
		System.out.println(" ==== 1. ȸ������ ====");
		String cname = "�̼���", ctel = "01011111111";
		result = dao.insertCustomer(cname, ctel);
		System.out.println(result==CustomerDAO.SUCCESS? cname+"�� ȸ������ ����. ����Ʈ 1000�� �־�帲" : cname+"ȸ������ ����");	
		System.out.println(" ==== 2. ��ȭ��ȣ �˻� ==== ");
		ctel = "%";
		customers = dao.ctelGetCustomers(ctel);
		if(customers.isEmpty()) {
			System.out.println(ctel+" ��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ�������ϼ���");
		}else {
			System.out.println("���̵�\t ��ȭ��ȣ\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
			for (CustomerDTO customer : customers) {
				System.out.println(customer);
			}
		}	
		System.out.println(" ==== 3. ��ǰ���� ==== ");
		result = dao.buy(2, 200000); // 2�� ���� 20���� ����
		if(result==CustomerDAO.SUCCESS) { // ��ǰ ���Ű� �����Ǹ� �����޼����� �Բ� �� ���� ���
			CustomerDTO customer = dao.getCustomer(2);
			System.out.println("��ǰ ���� �����մϴ�");
			System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
			System.out.println(customer);
		}else {
			System.out.println("cid�� ��ȿ���� �ʽ��ϴ�");
		}		
		System.out.println(" ==== 4. ������ ��� ====");
		System.out.println("�������� : " +dao.getLevelNames());
		String levelname = "SILVER";
		
		System.out.println(" ==== ���� �˻� ====");
		customers = dao.levelNameGetCustomers(levelname);
		if (customers.size() == 0) {
			System.out.println(levelname+" ���� �����ϴ�");
		} else {
			System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
			for (CustomerDTO customer : customers) {
				System.out.println(customer); 
			}
		}
		System.out.println(" ==== 5. ��ü ȸ�� ��� ====");
		customers = dao.getCustomer();
		if (customers.isEmpty()) {
			System.out.println("ȸ�� ����� �����ϴ�");
		}
		else {
			System.out.println("���̵�\t ��ȭ��ȣ\t\t �̸�\t ����Ʈ\t ���Ŵ�����\t ������\t �������� ���� ���ž�");
			for(CustomerDTO c : customers) {
				System.out.println(c);
			}
		}		
		System.out.println(" ==== 6. ȸ�� Ż�� ====");
		result = dao.deleteCustomer(ctel);
		System.out.println(result==CustomerDAO.SUCCESS? "ȸ�� Ż�� ����" : "��ȿ�� ��ȭ��ȣ�� �ƴմϴ�");
	}
}
