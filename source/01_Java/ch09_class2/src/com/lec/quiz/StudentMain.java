package com.lec.quiz;

public class StudentMain {
	private static void line() {
		for(int i=0; i<80; i++) {
			System.out.print("¡á");
		}
		System.out.println();
	}
	private static void line(char l) {
		System.out.print("\t");
		for(int i=0; i<65; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Student s1 = new Student("Á¤¿ì¼º", 90,80,95);
		Student s2 = new Student("±èÇÏ´Ã", 100,80,95);
		Student s3 = new Student("È²Á¤¹Î", 95,80,90);
		Student s4 = new Student("°­µ¿¿ø", 95,90,99);
		Student s5 = new Student("À¯¾ÆÀÎ", 90,90,90);
		Student[] students = {s1,s2,s3,s4,s5};
		String[] title = {"¹øÈ£", "ÀÌ¸§", "±¹¾î", "¿µ¾î", "¼öÇÐ", "ÃÑÁ¡", "Æò±Õ"};
		int[] total = new int[5];
		
		line();
		System.out.println("\t\t\t\t    ¼ºÀûÇ¥");
		line('-');
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		
		line('-');
		for(Student s : students) {
			s.infoPrint();
			total[0] += s.getKor();
			total[1] += s.getEng();
			total[2] += s.getMat();
			total[3] += s.getTot();
			total[4] += s.getAvg();
		}
		
		line('-');
		System.out.print("\tÃÑÁ¡\t");
		for (int t : total) {
			System.out.print("\t"+t);
		}
		System.out.print("\n\tÆò±Õ\t");
		for (int t : total) {
			System.out.print("\t"+t/students.length);
		}
		System.out.println();
		line();
	}
}
