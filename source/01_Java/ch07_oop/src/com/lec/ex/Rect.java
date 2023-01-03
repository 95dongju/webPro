package com.lec.ex;
// 클래스 : 속성, 생성자 함수, 메소드, setter, getter // 굳이 왜 하는 걸까요...?
public class Rect { // 클래스 명은 반드시 대문자로 시작
		private int width;
		private int height;
		//생성자가 없을 경우 JVM이 자동 생성
		public Rect() {} // 열고 아무 짓도 안함. 걍 클래스에 있으라는 뜻.(클래스명과 동일하게)>> 디폴트 생성자.
		public Rect(int side) {
			width = side;
			height = side;
		}
		public Rect(int width, int height) { //매개변수 2개짜리 생성자 함수
			this.width = width; 
			this.height = height;
		}
		public int area() {
			return width*height;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
	
}
