package com.lec.quiz;

public class QuizPoint3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		p1.setX(5); p1.setY(3); p1.setZ(4);
		Point3D p2 = (Point3D) p1.clone();
		Point3D p3 = new Point3D(6, 5, 5);
		System.out.println("p1�� ��: " +p1+"\np2�� ��: "+p2+"\np3�� ��: "+p3);
		if(p1!=p2 && p1.equals(p2)) {
			System.out.println("clone ����Ͽ� p1�� p2�� ������");
		}else {
			System.out.println("����");
		}
	}
}
