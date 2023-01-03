package com.lec.quiz;

import java.util.Date;

public interface ILendable {
	public byte STATE_BORROWED 	= 1; // "������"
	public byte STATE_NORMAL 	= 0; // "���Ⱑ��"
	public void checkOut(String borrower);  // ����
	public void checkOutDate(Date checkOutDate);
	public void checkIn() throws Exception; // �ݳ�
	public int LATE_FEE = 100;
}
