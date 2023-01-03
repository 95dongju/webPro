package com.lec.loopQuiz;

public class Quiz2_teacher {
	public static void main(String[] args) {
			int oddTotal =0;
			int evenTotal = 0;
			for (int i=1 ; i<11 ; i++) {
				if(i%2 == 0) {
					evenTotal += i;
				}else {
					oddTotal += i;
				}
			}
		System.out.println(oddTotal + "&" + evenTotal);
	}
}


