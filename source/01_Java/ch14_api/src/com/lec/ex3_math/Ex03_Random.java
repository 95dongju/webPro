package com.lec.ex3_math;

import java.util.Random;

// 0 <= Math.random() < 1의 double 난수
// 0 <= Math.random()*45 < 45
// 1 <= 				<= 45 / < 46 이렇게 하려면   1 <= (int)(Math.random()*45)+1 < 46
// Random random = new Random()
public class Ex03_Random {

	public static void main(String[] args) {
		System.out.println("1~45까지의 정수 난수: " +(int)(Math.random()*45)+1);
		Random random = new Random(); //시드값을 정하면 결과가 똑같아짐
		System.out.println("int 난수: " +random.nextInt()); //정수 난수 .nextInt()
		System.out.println("double 난수: " +random.nextDouble()); //실수 난수 .nextDouble() = Math.random()과 유사 0~1 미만의 실수 난수
		System.out.println("true/false 중 난수: " +random.nextBoolean()); //boolean 난수
		System.out.println("0부터 100까지의 정수 난수: " +random.nextInt(101));
		System.out.println("0부터 44까지의 정수 난수: " +random.nextInt(45));
		System.out.println("0부터 45까지의 정수 난수: " +random.nextInt(46));
		System.out.println("0부터 45까지의 정수 난수: " +random.nextInt(46)+1); // 1이 스트링이 되기 때문에 40+1인 401이 됨
		System.out.println("0부터 45까지의 정수 난수: " +(random.nextInt(46)+1)); // 괄호 안에 넣어야 함
		System.out.println("가위(0), 바위(1), 보(2) 중 하나 : " +random.nextInt(3));

	}
}
