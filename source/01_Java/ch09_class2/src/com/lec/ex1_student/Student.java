package com.lec.ex1_student;
// 데이터: name(String), kor(int), eng(int), mat(int), tot(int), avg(double)
// 메소드: infoString()-출력할 스트링, infoPrint()
// Student st = new Student(); --> 이렇게 스튜던트 객체를 만들게 되면 st 변수 안에 
public class Student {
	private String name;
	private int	   kor;
	private int    eng;
	private int    mat;
	private int    tot;
	private double avg;
	public Student() {}
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor  = kor;
		this.eng  = eng;
		this.mat  = mat;
		tot = kor + eng + mat;
		avg = tot/3.0;
		//avg (double)tot/3;
	}
	// Student s 객체 = new Student("정우성", 100, 100, 100);
	// sysout(s.infoString()) -> \t정우성\t100\t100 ...
	public String infoString() {
//		return "\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg;
		return String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n",name, kor, eng, mat, tot, avg);
	}
	//s.infoPrint();
	public void infoPrint() {
		System.out.printf("\t%s\t%d\t%d\t%d\t%d\t%.1f\n",name, kor, eng, mat, tot, avg);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
}