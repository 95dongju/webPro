package com.lec.quiz;
//Book book = new Book ("890��-01-11", "java", "ȫ�浿")
public class BookLib extends BookInfo implements ILendable {
	private String borrower; // ������ / ���� ���̸� �̸�, ���� �� �Ǿ� ������ null
	private String checkOutDate; // ������ / ���� ���̸� ��¥, ���� �� �Ǿ� ������ null
	private byte state; // ���Ⱑ��(0), ������(1)
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) { 
		if (state == STATE_BORROWED) {// ���� ������ �ƴ��� ���� Ȯ�� �ʿ��� = ���� ���̸� �޽��� �Ѹ��� ��
			System.out.println(getBookTitle() + " ������ ���� ���� ���Դϴ�");
			return; // ���� �� ���� ���� �� ���� ��, �ܼ� ������ ������ 
		}
		// state�� 0(STATE_NORMAR)�̶� ���� ������
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // "������" ���·� ��ȯ��
		System.out.println(getBookTitle() + " ������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : "+borrower+ "������ : "+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookTitle()+ " ������ �ݳ� �Ϸ�� å�Դϴ�. �����ϼ���.");
			return;
		}
		// state�� 1(STATE_BORROWED)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+ " ������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}
	
	@Override
	public void printState() {
		String msg = getBookNo()+ "\t" +getBookTitle()+ "(" +getWriter()+ "��)-"; // �������� ���� msg��� method�� ����
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "������";
		System.out.println(msg);
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
