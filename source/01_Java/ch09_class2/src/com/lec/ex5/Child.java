package com.lec.ex5;
// Child child1 = new Child("첫째");
// Child1.takeMoney(1000);
public class Child {
	private String name; // null이 들어감
//	MomPouch momPouch; // null이 들어감 --> 이렇게 되면 엄마 지갑 자체가 복사되기 때문에 공유하지 않아서 2000원이 복사됨.
	static MomPouch momPouch; //--> 이렇게 해야 엄마 지갑을 static으로 공유하기 때문에 같은 값이 공유됨.
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
		
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"가 "+money+"원 가져가서 엄마 지갑에 "+momPouch.money);
		}else {
			System.out.println(name+"가 돈 못 받음. 현재 엄마 지갑에 " +momPouch.money);
		}
	}
}
