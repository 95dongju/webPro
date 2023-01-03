package com.lec.ex6_wrapper;
// Wrapper 클래스: Integer, Double, Long, Boolean... 기초데이터를 객체데이터로 변환한 클래스
public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // 기초데이터 타입
		//Integer iObj = new Integer (10); // 객체데이터 타입 // new Integer(10) object 에 10 넣으면 자동으로 Integer 객체 생성됨
		Integer iObj = 10; // 객체이기 때문에 제공되는 method가 있음
		int sum = i+iObj;
		//int sum = i+iObj.intValue(); 
		//iObj는 객체이기 때문에 연산이 안되지만, iObj는 iObj.intValue(); 와 동일하기 때문에 알아서 바뀜.
		System.out.println("합은 "+sum);
		System.out.println(iObj.equals(10)); // 값이 같으면 true를 반환
		
	}
}
