package com.lec.ex2;

import com.lec.ex2_human.*;
import com.lec.ex2_human.kid.Kid; 
//ex2_human.* : 휴먼 패키지 아래에 있는 모든 클래스를 다 쓰겠다는 뜻
// ctrl shift o (블필요한 import 제거하는 용도)

public class HumanMain {
	public static void main(String[] args) {
//		Man man = new Man(); 
//		// 생성자 함수를 하나라도 만들면 default 생성자를 자동적으로 안 만들어 줌.
//		Man kim = new Man("홍길동", 22, 170, 65);
		Woman woman1 		= 		new Woman();
		Woman woman2 		= 		new Woman();
//	 레퍼런스 변수(객체변수) 선언      	객체생성 (인스턴스 생성)
		System.out.println("woman1과 woman2가 같은지 : "+(woman1 == woman2)); 
		System.out.println("woman1과 woman2가 같은지 : "+woman1.equals(woman2)); //객체끼리 비교할때는 equals 메소드 사용
		// 만들지 않아도 기본적으로 사용할 수 있는 메소드(상속)이 있음
		Man man = new Man();
		Kid kid1 = new Kid("아기"); //매개변수 있는 생성자 함수를 만들어 놨기 때문에 매개변수 없는 생성자 함수(디폴트 생성자 함수)는 자동으로 만들어지지 않음
		Man hong = new Man ("홍길동");
		Man kim = new Man("김길동", 22, 180, 67); // 67의 경우 double이라서 67.0이 됨.
		Man kim2 = kim;
		
		kim2.setHeight(185); kim2.setWeight(300);
		System.out.println("kim과 kim2가 같은 객체인가 : "+kim.equals(kim2));
		System.out.println("kim과 kim2가 같은 객체인가 : "+(kim == kim2));
		double bmi = kim.calculateBMI();
		System.out.println(kim2.getName()+"의 bmi 지수는 " +bmi);
	}
}

