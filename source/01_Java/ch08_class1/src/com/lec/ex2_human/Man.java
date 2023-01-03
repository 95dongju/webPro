package com.lec.ex2_human;
// �����Լ��� �׽�Ʈ���̶�� ���� ������
// Man kim = new Man("ȫ�浿", 22, 170, 65); // �Լ��� �����ε�
// Man kim = new Man("ȫ�浿");
// Man kim = new Man();
public class Man {
	private String name; // �����ʹ� �ݵ�� private
	private int age;
	private int height;
	private double weight;	
//�����ڰ� ������ �Լ��� ����� �����Ϸ��� ����Ʈ ������ �Լ��� ������ ����.
	public Man() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}// �Ű����� ���� ������ �Լ� ���������� ������ ��.
	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("������ 4�� �ʱ�ȭ�ϴ� ������ �Լ�");
	}	
	// �Ʒ� �����߱� ������ Man man("ȫ�浿"); new Man(170); ���� --> �Ű����� int height ȣ�� 
	public Man(String name) { // �Ű����� Ÿ���� �ٸ��� (string, int)�� �Լ��� �����ε� ����
		this.name = name;
		System.out.println("�̸� �ʱ�ȭ�ϴ� ������ �Լ�");
	}
	public Man(int height) { //�Ȱ��� �Ű����� Ÿ���̶�� �����ε� �Ұ���
		this.height = height;
	}
	public Man(double weight) {
		this.weight = weight;
	}
	public double calculateBMI() { //��ü���� height�� weight�� BMI���� ��� �� return
		double result = weight / ((height*0.01)*(height*0.01));
		return result;
	}
	//getter ���󿡼� API ������ �� ���Ϳ� ���Ͱ� �־�� ������ �� > ���������� �����
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	} 
	// getW�� �ĵ� �ڵ� �ϼ� ��
	// ��ť�� �������� ����� ������ ���콺 -> �ҽ� -> ���ʷ���Ʈ ���� �� ���� -> Select All Ŭ��
	
	//setter : name, age, height, weight
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
