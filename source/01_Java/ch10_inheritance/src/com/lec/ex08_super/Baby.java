package com.lec.ex08_super;

public class Baby extends Person {
	public Baby() {
		super(); // == Person()
		System.out.println("�Ű����� ���� Baby ������");
	}
	public Baby(String name, String character) {
		super(name, character); // �Ű����� ���� ������ ����, �Ű����� �ִ� �����ڸ� ȣ���� �� ���� == Person(name, character); �� ���ٿ� �����
//		setName(name);
//		setCharacter(character);
		System.out.println("�Ű����� �ִ� Baby ������");
	}
	@Override
	public void intro() {
		System.out.print("& �̻� �Ʊ� ");
		super.intro(); //�θ�Ŭ������ intro()
	}
}
