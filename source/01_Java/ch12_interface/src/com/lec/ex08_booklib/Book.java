package com.lec.ex08_booklib;
//Book book = new Book ("890��-01-11", "java", "ȫ�浿")
public class Book implements ILendable {
	private String bookNo; // ����° ���ں��͸� �빮�ڷ� (å��ȣ)
	private String bookTitle; // å ����
	private String writer; // ����
	private String borrower; // ������ / ���� ���̸� �̸�, ���� �� �Ǿ� ������ null
	private String checkOutDate; // ������ / ���� ���̸� ��¥, ���� �� �Ǿ� ������ null
	private byte state; // ���Ⱑ��(0), ������(1)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	} //������ �Լ�

	@Override
	public void checkOut(String borrower, String checkOutDate) { 
		if (state == STATE_BORROWED) {// ���� ������ �ƴ��� ���� Ȯ�� �ʿ��� = ���� ���̸� �޽��� �Ѹ��� ��
			System.out.println(bookTitle + " ������ ���� ���� ���Դϴ�");
			return; // ���� �� ���� ���� �� ���� ��, �ܼ� ������ ������ 
		}
		// state�� 0(STATE_NORMAR)�̶� ���� ������
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // "������" ���·� ��ȯ��
		System.out.println(bookTitle + " ������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : "+borrower+ "������ : "+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(bookTitle+ " ������ �ݳ� �Ϸ�� å�Դϴ�. �����ϼ���.");
			return;
		}
		// state�� 1(STATE_BORROWED)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+ " ������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}
	
	@Override
	public void printState() {
		String msg = bookNo+ "\t" +bookTitle+ "(" +writer+ "��)-"; // �������� ���� msg��� method�� ����
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "������";
		System.out.println(msg);
		
//		if(state == STATE_NORMAL) {
//			System.out.println(bookNo+ "\t" +bookTitle+ "(" +writer+ "��)- ���� ����");
//		}else if(state == STATE_BORROWED) {
//			System.out.println(bookNo+ "\t" +bookTitle+ "(" +writer+ "��)- ���� ��");
//		}else {
//			System.out.println(bookNo+ "\t" +bookTitle+ "(" +writer+ "��)-�̷� ���� ���� ��");
//		}
	}
	// getters (å�̸��� �ٲ� ���� ���� ������ ���͸� ������)
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
