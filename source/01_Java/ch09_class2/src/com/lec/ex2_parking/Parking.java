package com.lec.ex2_parking;

import com.lec.constant.Constant;

// no, inTime, outTime, fee
// 메소드: out(int outTime)
public class Parking {
	private String no;
	private int in;
	private int out;
	private int fee;
	// 상수가 바뀐다고 하면, constant로 가서 바꿈.
//	private final int HOURLYPARKINGRATE = 2000; // 상수(final 변수) --> 프로그램에서 바뀔 수 있는 값은 대문자로 작성 (final 변수는 클래스에서 변경이 불가능)
	public Parking() {}

	public Parking(String no, int in) {
		super();
		this.no = no;
		this.in = in;
	}
	public Parking(String no, int in, int out, int fee) {
		super();
		this.no = no;
		this.in = in;
		this.out = out;
		this.fee = fee;
	}
	public void out(int out) {
		this.out = out;
		fee = (out-in) * Constant.HOURLYPARKINGRATE;
	}
	public String infoStringIn() {
		return String.format("\"%s\"님 어서오세요\n입차시간 : %d시", no, in);
	}
	public String infoStringOut() {
		return String.format("\n\"%s\"님 안녕히 가세요\n입차시간 : %d시\n출차시간 : %d시\n 주차요금 :%d\n", no, in, out, fee);
	}
	public String getNo() {
		return no;
	}
	public int getIn() {
		return in;
	}
	public int getOut() {
		return out;
	}
	public int getFee() {
		return fee;
	}
}
