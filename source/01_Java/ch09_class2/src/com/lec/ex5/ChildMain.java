package com.lec.ex5;

public class ChildMain {
	public static void main(String[] args) {
		Child child1 = new Child ("Ã¹Â°");
		Child child2 = new Child ("µÑÂ°");
		Child child3 = new Child ("¼ÂÂ°");
		child1.takeMoney(1000);
		System.out.println("Ã¹Â° ¾ö¸¶ Áö°© µ· : "+child1.momPouch.money);
		System.out.println("µÑÂ° ¾ö¸¶ Áö°© µ· : "+child2.momPouch.money);
		System.out.println("¼ÂÂ° ¾ö¸¶ Áö°© µ· : "+child3.momPouch.money);
		System.out.println("static Áö°© : "+Child.momPouch.money);
		child2.takeMoney(1000);
		System.out.println("Ã¹Â° ¾ö¸¶ Áö°© µ· : "+child1.momPouch.money);
		System.out.println("µÑÂ° ¾ö¸¶ Áö°© µ· : "+child2.momPouch.money);
		System.out.println("¼ÂÂ° ¾ö¸¶ Áö°© µ· : "+child3.momPouch.money);
		System.out.println("static Áö°© : "+Child.momPouch.money);
		child3.takeMoney(1000);
		
	}
}

