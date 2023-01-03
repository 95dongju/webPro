package com.lec.loopQuiz;

public class Quiz2 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1 ; i<11 ; i++) {
			System.out.print(i);
			if(i%2 == 0) {
				System.out.print(" + ");
			}else if(i == 10) {
				System.out.print(" = ");
			}else {
				break;
			}
			tot += i;
			}
		System.out.println(tot);
	}
}

