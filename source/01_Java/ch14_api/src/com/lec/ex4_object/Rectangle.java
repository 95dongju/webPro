package com.lec.ex4_object;
// (1)  implements Cloneable --> 복제메소드
// (2) 복제 메소드 clone을 오버라이드
// new Rectangle(10,5,"빨강") 가로, 세로, 색상
// new Rectangle(10,5) --> 기본적으로 까만 사각형
// new Rectangle() --> 가로 0, 세로 0, 까만 사각형
// new Rectangle("노랑") --> 가로0, 세로 0, 노란 사각형
public class Rectangle implements Cloneable {
	private int width;
	private int height;
	private String color;
	public Rectangle() {
		color = "검정";
	}
	public Rectangle(String color) {
		this.color = color;
	}
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "검정";
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public String toString() { //객체 정보 스트링으로 return
		//return "가로:" +width+"cm, 세로: "+height+"cm, 색상: " +color+ "색 사각형";
		return String.format("가로 %dcm, 세로%dcm, %s색 사각형", width, height, color);
	}
	@Override
	public boolean equals(Object obj) { //r1.equals(r2) == r1 = this, r2 = obj
		if (obj != null && getClass() == obj.getClass()) {
			Rectangle other = (Rectangle)obj;
//			return width == other.width && height == other.height && color.equals(other.color);
			boolean widthChk = width==other.width;
			boolean heightChk = height==other.height;
			boolean colorChk = color.equals(other.color);
			return widthChk && heightChk && colorChk;
		}
		return false;
	}
	@Override
	//clone은 protected기 때문에 main함수에서는 쓸 수 없음.
	protected Object clone() throws CloneNotSupportedException { //throws CloneNotSupportedException 복제를 하다가 오류가 나면 호출한 곳으로 오류를 던짐
		// TODO Auto-generated method stub
		return super.clone();
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
