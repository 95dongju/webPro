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
			System.out.println("데이터를 입력하려면 (1)번\n"
					+ "직업을 검색하여 점수를 등수별로 출력하려면 (2)번\n"
					+ "모든 정보를 등수별로 출력하려면 (3)번을 누르세요\n");
			int you = sc.nextInt();
			if (you == 1) {
				System.out.print("이름을 입력하세요: ");
				String pname = sc.next();
				System.out.print("직업을 입력하세요: ");
				String jname = sc.next();
				System.out.print("국어 점수를 입력하세요: ");
				int kor = sc.nextInt();
				System.out.print("영어 점수를 입력하세요: ");
				int eng = sc.nextInt();
				System.out.print("수학 점수를 입력하세요: ");
				int mat = sc.nextInt();
				dao.insertPerson(new PersonDTO(pname, jname, kor, eng, mat));
				break;
			} else if (you == 2) {
				System.out.print("검색하고자 하는 직업을 입력하세요: ");
				String enterjob = sc.next();
				ArrayList<PersonDTO> dtos = dao.selectJname(enterjob);
				if(dtos.isEmpty()) {
					System.out.println(enterjob + "직업군의 사람은 없습니다");
				} else {
					for (PersonDTO d : dtos) {
						System.out.println(d);
					}
				}
			} else if (you == 3) {
				ArrayList<PersonDTO> dtos = dao.selectAll();
				dtos = dao.selectAll();
				if (dtos.size()==0) {
					System.out.println("등록된 사람이 없습니다");
				}else {
					for(int idx=0 ; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
				}
			} 
		}
	}
}
