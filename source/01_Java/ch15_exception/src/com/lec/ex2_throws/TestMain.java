package com.lec.ex2_throws;

public class TestMain {
	public static void main(String[] args) {
		try {
			new ThrowsEx(); // 예외
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 메세지 :" +e.getMessage());
		}
	}
}

