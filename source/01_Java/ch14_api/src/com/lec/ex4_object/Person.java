package com.lec.ex4_object;

public class Person {
	private long juminNo;  //9812132271626

	public Person() {
	}


	public Person(long juminNo) {
		super();
		this.juminNo = juminNo;
	}
	
	@Override
	public String toString() {
		return "주민번호는" +juminNo;
	}

	@Override
	public boolean equals(Object obj) {
		//this & obj의 주민번호가 같은지 다른지 여부를 return
		//return (this == obj); // = p1.equals(p2) : p1이 this. p2가 obj
//		return juminNo == ((Person)obj).juminNo; // 이렇게 하면 오브젝트 안의 정보를 비교함
		if(obj != null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}
