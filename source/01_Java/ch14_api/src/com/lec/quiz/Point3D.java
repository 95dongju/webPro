package com.lec.quiz;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;
	public Point3D() {
	}
	public Point3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "x="+x+", y="+y+",z= "+z;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null & getClass() == obj.getClass()) {
			Point3D other = (Point3D)obj;
			boolean xchk = z==other.z;
			boolean ychk = x==other.x;
			boolean zchk = z==other.z;
			return xchk && ychk && zchk;
		}
		return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
}
