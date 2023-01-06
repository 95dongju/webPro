package com.lec.ex2person_dtodao;

import java.util.ArrayList;

public class PersonDAOTest {
	public static void main(String[] args) {
		PersonDAO dao = PersonDAO.getInstance();
		System.out.println("--------- 1번 insert test ---------");
		PersonDTO dto = new PersonDTO ("홍길동", "배우", 90, 95, 99);
		dao.insertPerson(dto);
		System.out.println("--------- 2번 직업명 출력 test ---------");
		ArrayList<PersonDTO> dtos = dao.selectJname("가수");
		if (dtos.isEmpty()) {
			System.out.println("해당 직업의 사람이 등록되지 않았습니다");
		}else {
			for (PersonDTO d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("엠씨 검색결과");
		dtos = dao.selectJname("엠씨");
		if(dtos.size()!=0) {
			for(int idx=0 ; idx<dtos.size() ; idx++) {
				System.out.println(dtos.get(idx));
				if(idx%3==2) {
					System.out.println();
				}
			}
		}else {
			System.out.println("엠씨가 DB에 없습니다");
		}
		System.out.println("---------- 3번 ----------");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {
			System.out.println("등록된 사람이 없습니다.");
		} else {
			for(PersonDTO d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("직업명: " +dao.jnamelist());
	}
}
