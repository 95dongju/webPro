package com.lec.ex07;

public class RobotMain {
	public static void main(String[] args) {
		Robot[] robots = {new DanceRobot(), new DrawRobot(), new SingRobot()}; //Robot�� �� �� �ִ� �� ���� �� ������
		//�κ����� �� ��Ű�� ��ü�� ���� <= ����: Ŭ������ �޼ҵ�(�Ű������� robot�� �޾� ������ �޼ҵ带 ȣ����)
		RobotOrder order = new RobotOrder();
		for(Robot robot : robots) {
			order.action(robot);
			// ��ü.�޼ҵ�(robot)
		}
	}
}
