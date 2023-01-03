package com.lec.ex; // 클래스는 반드시 패키지 있어야 함
 // 
public class Car { //public은 외부에서 접근 가능하다는 뜻 // 클래스 = 설계도면 (붕어빵틀) / 객체 = 물건 (붕어빵)
//	public static void main(String[] args) { //static은 static영역에 따로 들어가기 때문에 메모리에 잡히지 않음
// 클래스에는 데이터 먼저 쓰고 메소드 써야 함. 클래스 : 속성(데이터)과 기능(메소드). 하나의 클래스에는 데이터와 메소드가 있음
// Car myCar(변수 = 객체) = new Car();
	//myCar.park()
		private String color;
		private int cc; //배기량
		private int speed;
		
		public void park() {
			speed = 0;
			System.out.println(color + "색 차 주차한다. 지금 속도 : " + speed);
		}
		public void drive() { //void = return타입 (리턴 안하는것)
			speed = 60;
			System.out.println(color + "색 차 운전한다. 지금 속도 : " + speed);
		}
		public void race() {
			speed = 120;
			System.out.println(color + "색 차 레이싱한다. 지금 속도 : " + speed);
		}// 클래스 완성! 클래스에는 속성 + 메소드
		// getter & setter (데이터를 get (객체 안의 속성 데이터) & 데이터를 set)
		// (color, cc, speed 를 get/set하려면 액세스 함수가 있어야 함)
		// Car car = new Car(); car.getColor() // 반드시 getColor라는 메소드를 만들어 놔야 함!
		// color : getColor/setColor, cc: getCc/setCc, speed: getSpeed/setSpeed
		// getter는 반드시 퍼블릭! 변수 성격
		public String getColor() {
			return color;
		}
		public void setColor(String color) { //set은 색을 설정하고 리턴하지 않기 때문에 void 사용
			this.color = color; // 매개변수로 들어온 color를 c가 입혀줌. this.color : 내 객체 안의 color
			
		}
		public int getCc() { //반드시 getCc, setCc로 설정해야 다른 API와 연동 가능!
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
