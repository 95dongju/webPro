package com.lec.ex07;

public class RobotMain {
	public static void main(String[] args) {
		Robot[] robots = {new DanceRobot(), new DrawRobot(), new SingRobot()}; //Robot은 할 수 있는 게 없음 즉 에러남
		//로봇에게 일 시키는 객체를 만듬 <= 선행: 클래스의 메소드(매개변수로 robot을 받아 적정한 메소드를 호출함)
		RobotOrder order = new RobotOrder();
		for(Robot robot : robots) {
			order.action(robot);
			// 객체.메소드(robot)
		}
	}
}
