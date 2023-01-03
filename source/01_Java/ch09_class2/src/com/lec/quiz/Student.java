package com.lec.quiz;
// 번호, 이름, 국, 영, 수, 총, 평
// new Student("정우성", 90,80,100)
public class Student {
	private int 	no;
	private String 	name;
	private int 	kor;
	private int 	eng;
	private int 	mat;
	private int		tot;
	private int 	avg;
	public static int count = 1;
	public Student() {}
	
	public Student(String name, int kor, int eng, int mat) {
		super();
		no = count++;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3;
	}

	public void infoPrint() {
		System.out.printf("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n",no, name, kor, eng, mat, tot, avg);
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public static void setCount(int count) {
		Student.count = count;

	}

	public int getCount() {
		return count;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getTot() {
		return tot;
	}

	public int getAvg() {
		return avg;
	}
	
}
