package com.lec.ex2_parking;

import com.lec.constant.Constant;

// no, inTime, outTime, fee
// �޼ҵ�: out(int outTime)
public class Parking {
	private String no;
	private int in;
	private int out;
	private int fee;
	// ����� �ٲ�ٰ� �ϸ�, constant�� ���� �ٲ�.
//	private final int HOURLYPARKINGRATE = 2000; // ���(final ����) --> ���α׷����� �ٲ� �� �ִ� ���� �빮�ڷ� �ۼ� (final ������ Ŭ�������� ������ �Ұ���)
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
		return String.format("\"%s\"�� �������\n�����ð� : %d��", no, in);
	}
	public String infoStringOut() {
		return String.format("\n\"%s\"�� �ȳ��� ������\n�����ð� : %d��\n�����ð� : %d��\n ������� :%d\n", no, in, out, fee);
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
