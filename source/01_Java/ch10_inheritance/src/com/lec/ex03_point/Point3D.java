package com.lec.ex03_point;
// x, y, infoPrint(��ǥ x=2, y=1�� �ֿܼ� ���) �� ����
public class Point3D extends Point { // �Ű����� ���� ������ �Լ��� ������ ������ (�⺻������ �׻� �����ϴ� ���̱� ����)
	private int z;
	public Point3D(int x, int y, int z) {
		System.out.println("�Ű����� �ִ� Point3D ������ �Լ� - x, y, z �� �ʱ�ȭ");
		setX(x);// this.x = x; �� private�̶� �� ��
		setY(y);
		this.z = z;// �� Ŭ������ �ִ� ���̶� this.z ��.
	}
//	public void infoPrint3D() {
//		System.out.println("��ǥ x= " + getX() + ", y= " + getY() + ", z= " + z);
//	} // �̰� ȿ�������� �ٲ�
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}
