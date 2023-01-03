package com.lec.ex07;
// �� ��Ű�� ��ü = RobotOrder order = new RobotOrder();
// order.action(robot); // action method ���� 
// = ��ǰȭ
public class RobotOrder { 
	public void action(Robot robot) { 
		// Robot Ŭ������ �ƹ��͵� ���� ������ robot.sing(); ���� �Ұ���
		//((SingRobot)robot).sing(); �̷��� �ϸ� ����ȯ �ż� ������ �� ������ ���� ���� �� ����
		if(robot instanceof DanceRobot) { //instanceof �� ������ �ƴ� ��ü�� Ÿ���� ����� ��
//			((DanceRobot)robot).dance(); ����ȯ �ؼ� �ٷ� ȣ���ϱ�. > �̷��� �ص� �Ǵµ� ������ �������� ������ �Ʒ�ó�� ��
			DanceRobot tempRobot = (DanceRobot)robot;
			tempRobot.dance();
		}else if(robot instanceof DrawRobot) {
			DrawRobot tempRobot = (DrawRobot)robot; //�ϴ� temp������ ����ȯ ���� �ϰ�
			tempRobot.draw(); // �Ͻ�Ű��
		}else if(robot instanceof SingRobot) {//else if�� ��� Ŭ���� �߰��� �� ���� ����� ���� ������ �� ����
			SingRobot tempRobot = (SingRobot)robot;
			tempRobot.sing();
		}else {
			System.out.println("Ȯ��� �κ� ������ �ʿ��մϴ�");
		}
	}
}

