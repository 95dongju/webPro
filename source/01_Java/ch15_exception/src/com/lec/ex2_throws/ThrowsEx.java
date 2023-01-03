package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() {
		actionC(); // 예외
	}
	private void actionC() { // 아래는 위타입이 가능한데 위는 위타입을 쓸수없음
		System.out.println("actionC 전반부");
		actionB(); // 예외
		System.out.println("actionC 후반부");
	}
	private void actionB() { //던지면 아래 실행하지 않고 해당 메소드를 호출한 곳으로 감
		System.out.println("actionB 전반부");
		actionA(); // 예외
		System.out.println("actionB 후반부");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException { //나를 호출한 곳으로 불러! 아래는 실행하지 않고 해당 절을 호출한 부분으로 던짐
		System.out.println("actionA 전반부");
		int[] arr = {0,1,2};
		System.out.println(arr[3]); // 예외는 항상 맨 위부터 
		System.out.println("actionA 후반부");
	}
	
//	private void actionA() {
//		System.out.println("actionA 전반부");
//		int[] arr = {0,1,2};
//		try {
//			System.out.println(arr[3]); // 예외는 항상 맨 위부터 
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("예외 메세지: " +e.getMessage());
//		}
//		System.out.println("actionA 후반부");
//	}
}
