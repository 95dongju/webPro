package com.lec.ex;

public class VarEx04 {
	public static void main(String[] args) {
		// ���� ������ ��ġ ������ ����. �ٸ� ���� ������ ���� ��õ.
		char c = '��'; //2byte
		int i = 20; //4byte
		long l = 2200000000L; // 8byte �Ҽ����� ������ ������ int, �Ҽ��� ������ ������ double - 22�� �Ѵ� ������ �ڿ� L/l ���̱�
		System.out.println("l = " + l);
		float f = 3.14159265359F; // 4byte ������ �ƴ϶� �÷�Ʈ��� ������ �ڿ� F ���̱� - �Ҽ��� ���� ���ǵǱ� ������ float ����� ����, double ����ϱ�
		System.out.println("f = " + f);
		double d = 3.14159265359; // 8byte
		System.out.println("t = " + d);
		boolean b = true; // 1byte ��/���� ��ҹ��� �����Ͽ� �ݵ�� �ҹ��ڷ� �ۼ�
		System.out.println("b = " + b);
		if(f == d) {// == ���� ���� ����� ��, ���ٸ� �Ʒ��� ù��° ���� ���� ���, �ٸ��ٸ� �ι�° ���� ���� �ⷰ��
			System.out.println("f�� t���� ����");
		}else {
			System.out.println("f�� t���� �ٸ���"); // �ٸ��ٰ� ��µ�
		}
		
		
		f = 10.1F; 
		d = 10.1;
		if(f == d) {
			System.out.println("f�� t���� ����");
		}else {
			System.out.println("f�� t���� �ٸ���"); // ���������δ� �ٸ��ٰ� ��µǱ� ������ double ����ϱ�!!
			}
		
		// ����(4byte)�� �Ǽ�(8byte)�� ������ ��� : i+d 8byte // �� ���� ����Ʈ������ ����
		System.out.println("i + d = " +(i+d)); //�� ���� ����Ʈ ������ ����
		
		//����(4byte)�� �Ǽ�(4byte)�� ������ ��� : 4byte
		System.out.println("i + i = " +(i+i));
		
		//������ ������??? �ϸ� �� ����
		System.out.println("i / 7 = " +(i/7));
		
	}
}


