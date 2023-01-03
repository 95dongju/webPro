package com.lec.ex1_student;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 90, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 80);
		Student s4 = new Student("강동원", 80, 80, 81);
		Student s5 = new Student("유아인", 70, 70, 70);
		Student[] students = {s1,s2,s3,s4,s5};
		String[] title = {"이름", "국어", "영어", "수학", "총점", "평균"};
//		int korTot=0;
//		int engTot=0;
//		int matTot=0;
//		int totTot=0;
//		int avgTot=0;
		int[] total = new int[5]; //0번 idx: 국어누적, 1번 idx: 영어누적 ... //new 연산자 이용해서 0으로 초기화
		
		line();
		System.out.println("\t\t\t    성적표");
		line('-');
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		line('-');
		for(Student student : students) {
			System.out.print(student.infoString());
			//student.infoPrint();
			// 총점변수 (국,영,수,총,평) 누적
			total[0] += student.getKor(); // 국어 누적
			total[1] += student.getEng(); // 영어 누적
			total[2] += student.getMat(); // 수학 누적
			total[3] += student.getTot(); // 총점 누적
//			total[4] = total[4] + student.getAvg(); //평균 누적 --> 에러 (형변환 아니어서 에러남)
			total[4] += student.getAvg(); // 평균 누적
		}
		line('-');
		System.out.print("\t총점");
		for(int t : total) {
			System.out.print("\t"+t);
		}
		System.out.print("\n\t평균");

		for(int t : total) {
//			System.out.print("\t" +t/students.length);
			System.out.printf("\t%.1f", (double)t/students.length);
		}
		System.out.println();
		line();
	}

	private static void line(char c) {
		// TODO Auto-generated method stub
		System.out.print("\t");
		for(int i=0 ; i<45; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private static void line() {
		for(int i=0 ; i<60 ; i++) {
			System.out.print("■");
		}
		System.out.println();
	}
}