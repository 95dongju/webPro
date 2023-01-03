package com.lec.ex2_human;
// 메인함수는 테스트용이라고 봐도 무방함
// Man kim = new Man("홍길동", 22, 170, 65); // 함수의 오버로딩
// Man kim = new Man("홍길동");
// Man kim = new Man();
public class Man {
	private String name; // 데이터는 반드시 private
	private int age;
	private int height;
	private double weight;	
//개발자가 생성자 함수를 만들면 컴파일러는 디폴트 생성자 함수를 만들지 않음.
	public Man() {
		System.out.println("매개변수 없는 생성자 함수");
	}// 매개변수 없는 생성자 함수 습관적으로 만들어야 함.
	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("데이터 4개 초기화하는 생성자 함수");
	}	
	// 아래 세팅했기 때문에 Man man("홍길동"); new Man(170); 가능 --> 매개변수 int height 호출 
	public Man(String name) { // 매개변수 타입이 다르면 (string, int)면 함수의 오버로딩 가능
		this.name = name;
		System.out.println("이름 초기화하는 생성자 함수");
	}
	public Man(int height) { //똑같은 매개변수 타입이라면 오버로딩 불가능
		this.height = height;
	}
	public Man(double weight) {
		this.weight = weight;
	}
	public double calculateBMI() { //객체안의 height와 weight로 BMI지수 계싼 후 return
		double result = weight / ((height*0.01)*(height*0.01));
		return result;
	}
	//getter 웹상에서 API 구동할 때 세터와 게터가 있어야 구동이 됨 > 습관적으로 만들기
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
	// getW만 쳐도 자동 완성 됨
	// 한큐에 가져오는 방법은 오른쪽 마우스 -> 소스 -> 제너레이트 게터 앤 세터 -> Select All 클릭
	
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
