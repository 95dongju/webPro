package com.lec.quiz;
//Book book = new Book ("890ㅁ-01-11", "java", "홍길동")
public class BookInfo {
	private String bookNo; // 세번째 글자부터만 대문자로 (책번호)
	private String bookTitle; // 책 제목
	private String writer; // 저자
	
	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	} 
}
