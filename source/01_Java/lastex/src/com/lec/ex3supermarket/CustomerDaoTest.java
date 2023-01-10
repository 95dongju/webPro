package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDAO dao = CustomerDAO.getInstance();
		int result;
		ArrayList<CustomerDTO> customers;
		System.out.println(" ==== 1. 회원가입 ====");
		String cname = "이순신", ctel = "01011111111";
		result = dao.insertCustomer(cname, ctel);
		System.out.println(result==CustomerDAO.SUCCESS? cname+"님 회원가입 감사. 포인트 1000점 넣어드림" : cname+"회원가입 실패");	
		System.out.println(" ==== 2. 전화번호 검색 ==== ");
		ctel = "%";
		customers = dao.ctelGetCustomers(ctel);
		if(customers.isEmpty()) {
			System.out.println(ctel+" 전화번호로 검색된 고객이 없습니다. 회원가입하세요");
		}else {
			System.out.println("아이디\t 전화번호\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
			for (CustomerDTO customer : customers) {
				System.out.println(customer);
			}
		}	
		System.out.println(" ==== 3. 물품구매 ==== ");
		result = dao.buy(2, 200000); // 2번 고객이 20만원 구매
		if(result==CustomerDAO.SUCCESS) { // 물품 구매가 성공되면 성공메세지와 함께 고객 정보 출력
			CustomerDTO customer = dao.getCustomer(2);
			System.out.println("물품 구매 감사합니다");
			System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
			System.out.println(customer);
		}else {
			System.out.println("cid가 유효하지 않습니다");
		}		
		System.out.println(" ==== 4. 레벨별 출력 ====");
		System.out.println("고객레벨명 : " +dao.getLevelNames());
		String levelname = "SILVER";
		
		System.out.println(" ==== 레벨 검색 ====");
		customers = dao.levelNameGetCustomers(levelname);
		if (customers.size() == 0) {
			System.out.println(levelname+" 고객이 없습니다");
		} else {
			System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
			for (CustomerDTO customer : customers) {
				System.out.println(customer); 
			}
		}
		System.out.println(" ==== 5. 전체 회원 출력 ====");
		customers = dao.getCustomer();
		if (customers.isEmpty()) {
			System.out.println("회원 목록이 없습니다");
		}
		else {
			System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
			for(CustomerDTO c : customers) {
				System.out.println(c);
			}
		}		
		System.out.println(" ==== 6. 회원 탈퇴 ====");
		result = dao.deleteCustomer(ctel);
		System.out.println(result==CustomerDAO.SUCCESS? "회원 탈퇴 성공" : "유효한 전화번호가 아닙니다");
	}
}
