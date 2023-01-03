package com.lec.ex08_booklib;
//Book book = new Book ("890ㅁ-01-11", "java", "홍길동")
public class Book implements ILendable {
	private String bookNo; // 세번째 글자부터만 대문자로 (책번호)
	private String bookTitle; // 책 제목
	private String writer; // 저자
	private String borrower; // 대출인 / 대출 중이면 이름, 대출 안 되어 있으면 null
	private String checkOutDate; // 대출일 / 대출 중이면 날짜, 대출 안 되어 있으면 null
	private byte state; // 대출가능(0), 대출중(1)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	} //생성자 함수

	@Override
	public void checkOut(String borrower, String checkOutDate) { 
		if (state == STATE_BORROWED) {// 대출 중인지 아닌지 먼저 확인 필요함 = 대출 중이면 메시지 뿌리고 끝
			System.out.println(bookTitle + " 도서는 현재 대출 중입니다");
			return; // 리턴 후 값을 넣을 수 없을 뿐, 단순 리턴은 가능함 
		}
		// state가 0(STATE_NORMAR)이라서 대출 진행함
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // "대출중" 상태로 전환함
		System.out.println(bookTitle + " 도서가 대출 처리 되었습니다");
		System.out.println("대출인 : "+borrower+ "대출일 : "+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(bookTitle+ " 도서는 반납 완료된 책입니다. 점검하세요.");
			return;
		}
		// state가 1(STATE_BORROWED)이라 반납 처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+ " 도서가 반납 완료되었습니다");
	}
	
	@Override
	public void printState() {
		String msg = bookNo+ "\t" +bookTitle+ "(" +writer+ "著)-"; // 공통적인 것을 msg라는 method에 넣음
		msg += state == STATE_NORMAL ? "대출가능" : "대출중";
		System.out.println(msg);
		
//		if(state == STATE_NORMAL) {
//			System.out.println(bookNo+ "\t" +bookTitle+ "(" +writer+ "著)- 대출 가능");
//		}else if(state == STATE_BORROWED) {
//			System.out.println(bookNo+ "\t" +bookTitle+ "(" +writer+ "著)- 대출 중");
//		}else {
//			System.out.println(bookNo+ "\t" +bookTitle+ "(" +writer+ "著)-이런 일은 없을 것");
//		}
	}
	// getters (책이름이 바뀔 일이 없기 때문에 게터만 가져옴)
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
}
