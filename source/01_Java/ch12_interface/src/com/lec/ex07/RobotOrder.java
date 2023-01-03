package com.lec.ex07;
// 일 시키는 객체 = RobotOrder order = new RobotOrder();
// order.action(robot); // action method 정의 
// = 부품화
public class RobotOrder { 
	public void action(Robot robot) { 
		// Robot 클래스에 아무것도 없기 때문에 robot.sing(); 실행 불가능
		//((SingRobot)robot).sing(); 이렇게 하면 형변환 돼서 에러는 안 나지만 문제 생길 수 있음
		if(robot instanceof DanceRobot) { //instanceof 는 변수가 아닌 객체의 타입을 물어보는 것
//			((DanceRobot)robot).dance(); 형변환 해서 바로 호출하기. > 이렇게 해도 되는데 가독성 떨어지기 때문에 아래처럼 씀
			DanceRobot tempRobot = (DanceRobot)robot;
			tempRobot.dance();
		}else if(robot instanceof DrawRobot) {
			DrawRobot tempRobot = (DrawRobot)robot; //일단 temp변수로 형변환 먼저 하고
			tempRobot.draw(); // 일시키기
		}else if(robot instanceof SingRobot) {//else if로 써야 클래스 추가될 때 오류 생기는 것을 방지할 수 있음
			SingRobot tempRobot = (SingRobot)robot;
			tempRobot.sing();
		}else {
			System.out.println("확장된 로봇 구현이 필요합니다");
		}
	}
}

