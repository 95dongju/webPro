package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Book book = new Book ("890��-01-11", "java", "ȫ�浿")
public class Book implements ILendable {
	private String bookNo; // ����° ���ں��͸� �빮�ڷ� (å��ȣ)
	private String bookTitle; // å ����
	private String writer; // ����
	private String borrower; // ������ / ���� ���̸� �̸�, ���� �� �Ǿ� ������ null
	private Date checkOutDate;
	private byte state; // ���Ⱑ��(0), ������(1)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	SimpleDateFormat 	sdf = new SimpleDateFormat("yyyy�� MM�� dd��");

	public void checkOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	@Override
	public void checkOut(String borrower) { 
		if (state == STATE_BORROWED) {
			System.out.println(bookTitle + " ������ ���� ���� ���Դϴ�");
			return; 
		}
		// state�� 0(STATE_NORMAR)�̶� ���� ������
		this.borrower = borrower;
		state = STATE_BORROWED;
		System.out.println(bookTitle + " ������ ���� ó�� �Ǿ����ϴ�");
		Date nowOut = new Date();
		checkOutDate = nowOut;
		System.out.println("������ : "+borrower+ "������ : "+sdf.format(checkOutDate));
	}
	
	
	@Override
	public void checkIn() throws Exception {
		if (state==STATE_BORROWED){
			Date nowIn = new Date();
			long nowMillis = nowIn.getTime();
			long checkMillis = checkOutDate.getTime();
			int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));
			if(day>14) {
				System.out.println("���� ��¥: " +sdf.format(nowIn)+"\n���� ��¥: "+sdf.format(checkOutDate)
				+"\n���� �� " +(day-14)+"�� ����Ͽ����ϴ�"
				+ "\n��ü�� ���� 100�� �ΰ��մϴ�"
				+ "\n�����Ͻ� ��ü��� " +(day-14)*LATE_FEE+"�Դϴ�.");
				System.out.print("��ü�Ḧ �޾ҽ��ϱ�(Y/N)?");
				Scanner scanner = new Scanner(System.in);
				if(!scanner.next().trim().equalsIgnoreCase("y")) { //y�� ������ �� �ƴϴϱ� ���� �ٷ� ����
					return;
				}
			}
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(bookTitle+ " ������ �ݳ� �Ϸ�Ǿ����ϴ�");
		} else {
			throw new Exception (bookTitle+ " ������ �ݳ� �Ϸ�� å�Դϴ�. �����ϼ���.");
		} 
	}
	
	@Override
	public String toString() {
		String msg = bookNo+ "\t" +bookTitle+ "(" +writer+ "��)-\t";
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "������\t"+sdf.format(checkOutDate);
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
