package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() {
		actionC(); // ����
	}
	private void actionC() { // �Ʒ��� ��Ÿ���� �����ѵ� ���� ��Ÿ���� ��������
		System.out.println("actionC ���ݺ�");
		actionB(); // ����
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() { //������ �Ʒ� �������� �ʰ� �ش� �޼ҵ带 ȣ���� ������ ��
		System.out.println("actionB ���ݺ�");
		actionA(); // ����
		System.out.println("actionB �Ĺݺ�");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException { //���� ȣ���� ������ �ҷ�! �Ʒ��� �������� �ʰ� �ش� ���� ȣ���� �κ����� ����
		System.out.println("actionA ���ݺ�");
		int[] arr = {0,1,2};
		System.out.println(arr[3]); // ���ܴ� �׻� �� ������ 
		System.out.println("actionA �Ĺݺ�");
	}
	
//	private void actionA() {
//		System.out.println("actionA ���ݺ�");
//		int[] arr = {0,1,2};
//		try {
//			System.out.println(arr[3]); // ���ܴ� �׻� �� ������ 
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("���� �޼���: " +e.getMessage());
//		}
//		System.out.println("actionA �Ĺݺ�");
//	}
}
