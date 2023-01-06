package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDAO dao = PersonDAO.getInstance();
		ArrayList<String> jobs = dao.jnamelist();
		while (true) {
			System.out.println("�����͸� �Է��Ϸ��� (1)��\n"
					+ "������ �˻��Ͽ� ������ ������� ����Ϸ��� (2)��\n"
					+ "��� ������ ������� ����Ϸ��� (3)���� ��������\n");
			int you = sc.nextInt();
			if (you == 1) {
				System.out.print("�̸��� �Է��ϼ���: ");
				String pname = sc.next();
				System.out.print("������ �Է��ϼ���: ");
				String jname = sc.next();
				System.out.print("���� ������ �Է��ϼ���: ");
				int kor = sc.nextInt();
				System.out.print("���� ������ �Է��ϼ���: ");
				int eng = sc.nextInt();
				System.out.print("���� ������ �Է��ϼ���: ");
				int mat = sc.nextInt();
				dao.insertPerson(new PersonDTO(pname, jname, kor, eng, mat));
				break;
			} else if (you == 2) {
				System.out.print("�˻��ϰ��� �ϴ� ������ �Է��ϼ���: ");
				String enterjob = sc.next();
				ArrayList<PersonDTO> dtos = dao.selectJname(enterjob);
				if(dtos.isEmpty()) {
					System.out.println(enterjob + "�������� ����� �����ϴ�");
				} else {
					for (PersonDTO d : dtos) {
						System.out.println(d);
					}
				}
			} else if (you == 3) {
				ArrayList<PersonDTO> dtos = dao.selectAll();
				dtos = dao.selectAll();
				if (dtos.size()==0) {
					System.out.println("��ϵ� ����� �����ϴ�");
				}else {
					for(int idx=0 ; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
				}
			} 
		}
	}
}
