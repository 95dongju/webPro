package com.lec.ex; // Ŭ������ �ݵ�� ��Ű�� �־�� ��
 // 
public class Car { //public�� �ܺο��� ���� �����ϴٴ� �� // Ŭ���� = ���赵�� (�ؾƲ) / ��ü = ���� (�ؾ)
//	public static void main(String[] args) { //static�� static������ ���� ���� ������ �޸𸮿� ������ ����
// Ŭ�������� ������ ���� ���� �޼ҵ� ��� ��. Ŭ���� : �Ӽ�(������)�� ���(�޼ҵ�). �ϳ��� Ŭ�������� �����Ϳ� �޼ҵ尡 ����
// Car myCar(���� = ��ü) = new Car();
	//myCar.park()
		private String color;
		private int cc; //��ⷮ
		private int speed;
		
		public void park() {
			speed = 0;
			System.out.println(color + "�� �� �����Ѵ�. ���� �ӵ� : " + speed);
		}
		public void drive() { //void = returnŸ�� (���� ���ϴ°�)
			speed = 60;
			System.out.println(color + "�� �� �����Ѵ�. ���� �ӵ� : " + speed);
		}
		public void race() {
			speed = 120;
			System.out.println(color + "�� �� ���̽��Ѵ�. ���� �ӵ� : " + speed);
		}// Ŭ���� �ϼ�! Ŭ�������� �Ӽ� + �޼ҵ�
		// getter & setter (�����͸� get (��ü ���� �Ӽ� ������) & �����͸� set)
		// (color, cc, speed �� get/set�Ϸ��� �׼��� �Լ��� �־�� ��)
		// Car car = new Car(); car.getColor() // �ݵ�� getColor��� �޼ҵ带 ����� ���� ��!
		// color : getColor/setColor, cc: getCc/setCc, speed: getSpeed/setSpeed
		// getter�� �ݵ�� �ۺ�! ���� ����
		public String getColor() {
			return color;
		}
		public void setColor(String color) { //set�� ���� �����ϰ� �������� �ʱ� ������ void ���
			this.color = color; // �Ű������� ���� color�� c�� ������. this.color : �� ��ü ���� color
			
		}
		public int getCc() { //�ݵ�� getCc, setCc�� �����ؾ� �ٸ� API�� ���� ����!
			return cc;
		}
		public void setCc(int cc) {
			this.cc = cc;
		}
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}

}
