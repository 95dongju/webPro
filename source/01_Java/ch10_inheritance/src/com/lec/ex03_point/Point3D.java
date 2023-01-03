package com.lec.ex03_point;
// x, y, infoPrint(좌표 x=2, y=1을 콘솔에 출력) 가 들어옴
public class Point3D extends Point { // 매개변수 없는 생성자 함수가 없으면 에러남 (기본적으로 항상 실행하는 것이기 때문)
	private int z;
	public Point3D(int x, int y, int z) {
		System.out.println("매개변수 있는 Point3D 생성자 함수 - x, y, z 값 초기화");
		setX(x);// this.x = x; 는 private이라서 안 됨
		setY(y);
		this.z = z;// 본 클래스에 있는 값이라 this.z 됨.
	}
//	public void infoPrint3D() {
//		System.out.println("좌표 x= " + getX() + ", y= " + getY() + ", z= " + z);
//	} // 이걸 효과적으로 바꿈
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}
