package com.lec.ex2_throws;

public class TestMain {
	public static void main(String[] args) {
		try {
			new ThrowsEx(); // ����
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("���� �޼��� :" +e.getMessage());
		}
	}
}

