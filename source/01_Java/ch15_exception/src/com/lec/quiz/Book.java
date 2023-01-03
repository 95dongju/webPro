package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Book book = new Book ("890ㅁ-01-11", "java", "홍길동")
public class Book implements ILendable {
	private String bookNo; // 세번째 글자부터만 대문자로 (책번호)
	private String bookTitle; // 책 제목
	private String writer; // 저자
	private String borrower; // 대출인 / 대출 중이면 이름, 대출 안 되어 있으면 null
	private Date checkOutDate;
	private byte state; // 대출가능(0), 대출중(1)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	SimpleDateFormat 	sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

	public void checkOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	@Override
	public void checkOut(String borrower) { 
		if (state == STATE_BORROWED) {
			System.out.println(bookTitle + " 도서는 현재 대출 중입니다");
			return; 
		}
		// state가 0(STATE_NORMAR)이라서 대출 진행함
		this.borrower = borrower;
		state = STATE_BORROWED;
		System.out.println(bookTitle + " 도서가 대출 처리 되었습니다");
		Date nowOut = new Date();
		checkOutDate = nowOut;
		System.out.println("대출인 : "+borrower+ "대출일 : "+sdf.format(checkOutDate));
	}
	
	
	@Override
	public void checkIn() throws Exception {
		if (state==STATE_BORROWED){
			Date nowIn = new Date();
			long nowMillis = nowIn.getTime();
			long checkMillis = checkOutDate.getTime();
			int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));
			if(day>14) {
				System.out.println("현재 날짜: " +sdf.format(nowIn)+"\n빌린 날짜: "+sdf.format(checkOutDate)
				+"\n빌린 지 " +(day-14)+"일 경과하였습니다"
				+ "\n연체료 일일 100원 부과합니다"
				+ "\n지급하실 연체료는 " +(day-14)*LATE_FEE+"입니다.");
				System.out.print("연체료를 받았습니까(Y/N)?");
				Scanner scanner = new Scanner(System.in);
				if(!scanner.next().trim().equalsIgnoreCase("y")) { //y를 저장할 게 아니니까 여기 바로 담음
					return;
				}
			}
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(bookTitle+ " 도서가 반납 완료되었습니다");
		} else {
			throw new Exception (bookTitle+ " 도서는 반납 완료된 책입니다. 점검하세요.");
		} 
	}
	
	@Override
	public String toString() {
		String msg = bookNo+ "\t" +bookTitle+ "(" +writer+ "著)-\t";
		msg += state == STATE_NORMAL ? "대출가능" : "대출중\t"+sdf.format(checkOutDate);
		return msg;
	}

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

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
}
