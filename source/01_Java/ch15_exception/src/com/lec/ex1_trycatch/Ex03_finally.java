package com.lec.ex1_trycatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[] aArr = {0,1,2};
		for(int i=0 ; i<=aArr.length ; i++) {
			try {
				System.out.println("arr[" +i+"] = " +aArr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외메시지: " +e.getMessage());
			}finally { // 예외가 발생되든 안되든 항상 수행함 ==> try나 catch절에서 수행한 것을 정리 및 마무리 작업을 finally절에서 함
				System.out.println("try절 실행 후에도, catch절 실행후에도 실행되는 절");
			}
		}//for
	}//main
}
