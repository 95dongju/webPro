package com.lec.quiz;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_OutputSteam {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		Date now = new Date();
		String name, tel, birthStr, address ;
		try {
			os = new FileOutputStream("src/com/lec/quiz/member.txt", true);
			while(true) {
				System.out.println("회원 가입 하시겠습니까? (종료: n)");
				if(sc.next().trim().equalsIgnoreCase("n")) break;
				
				System.out.println("이름: ");
				name = sc.next();
				byte[] nameBs = name.getBytes();
				os.write(nameBs);
				
				System.out.println("전화번호: ");
				tel = sc.next();
				byte[] telBs = tel.getBytes();
				os.write(telBs);
				
				System.out.println("생년월일 (ex.1995-08-02): ");
				birthStr = sc.next();
				byte[] birthBs = birthStr.getBytes();
				os.write(birthBs);
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
				String nowStr = sdf1.format(now);
				String birth = birthStr.substring(birthStr.indexOf("-")+1);
				
				if(birth.equals(nowStr)) {
					System.out.println("생일 축하합니다!");
				}
				// birthStr = "1995-08-02"
				// new Date(95, 7, 2)
//				StringTokenizer token = new StringTokenizer(birthStr, "-");
//				if(token.countTokens()==3) {
//					int year = Integer.parseInt(token.nextToken());
//					int month = Integer.parseInt(token.nextToken());
//					int day = Integer.parseInt(token.nextToken());
//					Date birthday = new Date(year-1990, month-1, 2);}
				
				System.out.println("주소: ");
				address = sc.next();
				byte[] addBs = address.getBytes();
				os.write(addBs);
				System.out.println("회원가입 완료");
				members.add(new Member (name,tel,birthStr,address));
			}
			if (members.isEmpty()) {
				System.out.println("회원 가입 한 사람이 없습니다");
			}
			else {
				for(Member member : members) {
					System.out.println(member);
				}
				System.out.println("\t\t\t...이하"+members.size()+"명 가입");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			sc.close();
		}
	} //main
}//class