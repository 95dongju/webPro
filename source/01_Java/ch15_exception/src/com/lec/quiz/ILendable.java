package com.lec.quiz;

import java.util.Date;

public interface ILendable {
	public byte STATE_BORROWED 	= 1; // "대출중"
	public byte STATE_NORMAL 	= 0; // "대출가능"
	public void checkOut(String borrower);  // 대출
	public void checkOutDate(Date checkOutDate);
	public void checkIn() throws Exception; // 반납
	public int LATE_FEE = 100;
}
