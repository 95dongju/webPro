package com.lec.ex2person_dtodao;

import java.util.ArrayList;

public class PersonDAOTest {
	public static void main(String[] args) {
		PersonDAO dao = PersonDAO.getInstance();
		System.out.println("--------- 1�� insert test ---------");
		PersonDTO dto = new PersonDTO ("ȫ�浿", "���", 90, 95, 99);
		dao.insertPerson(dto);
		System.out.println("--------- 2�� ������ ��� test ---------");
		ArrayList<PersonDTO> dtos = dao.selectJname("����");
		if (dtos.isEmpty()) {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�");
		}else {
			for (PersonDTO d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("���� �˻����");
		dtos = dao.selectJname("����");
		if(dtos.size()!=0) {
			for(int idx=0 ; idx<dtos.size() ; idx++) {
				System.out.println(dtos.get(idx));
				if(idx%3==2) {
					System.out.println();
				}
			}
		}else {
			System.out.println("������ DB�� �����ϴ�");
		}
		System.out.println("---------- 3�� ----------");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {
			System.out.println("��ϵ� ����� �����ϴ�.");
		} else {
			for(PersonDTO d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("������: " +dao.jnamelist());
	}
}
