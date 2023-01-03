package com.lec.ex4_boxorrect;

public class BoxOrRectMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(5,10);
		box.infoPrint(); //box에 대한 정보
		System.out.println(box.infostring()); //box에 대한 정보
		System.out.println(rect.infostring()); //box에 대한 정보
	}
}

