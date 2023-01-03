package com.lec.quiz;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890ㅁ-01-11","java","홍길동"),
						new BookLib("890ㅁ-01-12","oracle","오길동"),
						new BookLib("890ㅁ-02-11","mysql","마길동"),
						new BookLib("890ㅁ-01-01","jbdc","제이디"),
						new BookLib("890ㅁ-01-01","html","이에이"),};
		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호 (1:대출 / 2:반납 /3:책리스트 / 0:종료)
		int idx; // 대출하거나 반납할 때, 조회된 책의 index
		String bTitle, borrower, checkOutDate;
		do {
			System.out.print("1: 대출 / 2: 반납 / 3: 책 리스트 / 0: 종료");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // 대출로직 : 1.책 이름 입력 받기 > 2.책 조회 > 3.책상태확인 > 4.대출인 입력 > 5.대출일 입력 > 6.대출메소드 호출
				// 1.책이름 입력
				System.out.print("대출하고자 하는 책 이름을 입력하세요: ");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음					
				// 2.책 조회
//				for (int idx=0 ; idx<books.length ; idx++) // idx를 여기에 선언하면 밑으로 나왔을 때 idx를 모름, 그래서 위에서 선언해야 함
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) { // String끼리 비교할 때는 .equals 사용함
						break; // if가 true면 빠져나오고, false면 다시 for문을 돔
					}
				}// for --> idx번째 책으로 진행
				if(idx == books.length) {
					System.out.print("현재 보유하지 않은 도서입니다.");
				}else { // book[idx] 도서를 대출하겠다
					// 3.책 상태 확인
					if (books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("대출 중인 도서입니다");
					}else {
					// 4.대출인 입력
						System.out.print("대출인을 입력하세요: ");
						borrower = scanner.next(); // space 넣으면 안됨
					// 5.대출일 입력
						System.out.print("대출일을 입력하세요: ");
						checkOutDate = scanner.next(); // space 넣으면 안됨
					// 6.대출 메소드 호출
						books[idx].checkOut(borrower, checkOutDate);
					} // if - 상태확인
				} // if - 도서 조회
				break;
			case 2: // 반납로직 : 1.책 이름 입력 > 2.책 조회 > 3.반납메소드 호출
				System.out.println("반납하고자 하는 책 이름을 입력하세요: ");
				bTitle = scanner.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) { // String끼리 비교할 때는 .equals 사용함
						break; // if가 true면 빠져나오고, false면 다시 for문을 돔
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					// 반납 메소드 호출
					books[idx].checkIn();
				}
				break;
			case 3: // 책 리스트 출력 : for문을 이용해서 출력
				for(BookLib book : books) {
					book.printState();
				}
			}
		}while(fn!=0);
		System.out.println("종료합니다");
	}
}