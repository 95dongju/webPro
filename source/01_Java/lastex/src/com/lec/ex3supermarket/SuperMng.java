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
			System.out.print("1: 회원가입, 2:전화번호 검색, 3: 물품구매, 4: 레벨별출력, 5: 전체출력, 6: 탈퇴, 그외는 종료");
			fn = sc.next();
			switch(fn) {
			case "1": 
				System.out.print("가입할 회원 이름:");
				String cname = sc.next();
				System.out.print("가입할 회원 번호:");
				String ctel = sc.next();
//				int result = dao.insertCustomer(ctel, cname);
				int result = dao.insertCustomer(new CustomerDTO(cname, ctel));
				System.out.println(result==CustomerDAO.SUCCESS? cname+"님 회원가입 감사합니다. 포인트 1000점." : "회원가입 실패");
				break;
			case "2":
				System.out.print("검색할 전화번호: ");
				String searchTel = sc.next();
				customers = dao.ctelGetCustomers(searchTel);
				if(customers.isEmpty()) {
					System.out.println(searchTel+" 전화번호로 검색된 고객이 없습니다. 회원가입하세요.");
				} else {
					System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
					for (CustomerDTO customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3":
				System.out.print("고객아이디 (고객아이디를 모를 경우, 검색) :");
				int cid = sc.nextInt();
				System.out.print("물품가격: ");
				int price = sc.nextInt();
				result = dao.buy(cid, price);
				if (result==CustomerDAO.SUCCESS) {
					System.out.println("물품구매 감사합니다"+price+"원 구매하여 고객님의 데이터가 아래와 같이 되었습니다");
					CustomerDTO customer = dao.getCustomer(cid);
					System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
					System.out.println(customer);
				} else {
					System.out.println(cid+"는 유효한 고객 아이디가 아닙니다");
				}
				break;
			case "4":
				System.out.print("검색할 레벨 " +dao.getLevelNames() +" 입력하세요 : ");
				String levelName = sc.next();
				customers = dao.levelNameGetCustomers(levelName);
				if(customers.size()==0) {
					System.out.println("해당 레벨 ("+levelName+")의 고객이 검색되지 않습니다");
				} else {
					System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
					for (CustomerDTO customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "5":
				customers = dao.getCustomer();
				if(customers.size()==0) {
					System.out.println("고객이 없습니다");
				} else {
					System.out.println("아이디\t 전화번호\t\t 이름\t 포인트\t 구매누적액\t 고객레벨\t 레벨업을 위한 구매액");
					for (CustomerDTO customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6":
				System.out.print("탈퇴할 고객 전화번호를 입력하세요 : ");
				ctel = sc.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDAO.SUCCESS? "회원 탈퇴 성공" : "유효한 전화번호가 아닙니다");
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6"));
		System.out.println("BYE");
	}
}
