package com.lec.ex4_object;

public class Person {
	private long juminNo;  //9812132271626

	public Person() {
	}


	public Person(long juminNo) {
		super();
		this.juminNo = juminNo;
	}
	
	@Override
	public String toString() {
		return "�ֹι�ȣ��" +juminNo;
	}

	@Override
	public boolean equals(Object obj) {
		//this & obj�� �ֹι�ȣ�� ������ �ٸ��� ���θ� return
		//return (this == obj); // = p1.equals(p2) : p1�� this. p2�� obj
//		return juminNo == ((Person)obj).juminNo; // �̷��� �ϸ� ������Ʈ ���� ������ ����
		if(obj != null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}
