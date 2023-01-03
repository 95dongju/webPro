package com.lec.ex6_member;

public class MemberMain {
	public static void main(String[] args) {
		
		Member mem = new Member("aaa","xxx","홍길동","hong@company.com","서울 강남구","01-01",'m');
		System.out.println(mem.infoString());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		Member m1 = new Member("aaa","xxx","홍길동","hong@company.com","서울 강남구","01-01",'m');
		Member[] ber = new Member[2];
		ber[0] = m1;
		ber[1] = new Member("bbb","zzz","동길홍","hong@company.com","서울 강남구","01-01",'m');
		
		for(int idx=0 ; idx<ber.length ; idx++) {
			System.out.println(ber[idx].infoString());
		}
		System.out.println("_______________________");
		
		for(Member m : ber) {
			System.out.println(m.infoString());
		}
	}
}
