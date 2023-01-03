package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MemberTestMain_OutputSteam2 {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Date now = new Date();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String name, tel, birthStr, address;
			System.out.print("ȸ������ �Ͻðڽ��ϱ�? (����� N)");
			String answer = sc.next().trim();
			if(answer.equalsIgnoreCase("n"))
				break;
			System.out.print("�̸��� �Է��ϼ���: ");
			name = sc.next();
			System.out.print("��ȭ��ȣ�� �Է��ϼ���: ");
			tel = sc.next();
			System.out.print("������ �Է��ϼ��� (ex: 1995-08-02): ");
			birthStr = sc.next();
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
			String today = sdf1.format(now);
			String birth = birthStr.substring(birthStr.indexOf("-")+1);
			if(birth.equals(today)) {
				System.out.println("���� �����մϴ�!");
			}
			System.out.print("�ּҸ� �Է��ϼ���: ");
			address = sc.next();
			members.add(new Member(name, tel, birth, address));
			OutputStream os = null;
			try {
				os = new FileOutputStream("src/com/lec/quiz/member2.txt", true);
				for(Member member : members) {
					System.out.println(member);
					os.write(member.toString().getBytes());
				}
				String msg = String.format("\t\t\t.... ���� %d�� ����", members.size());
				System.out.println(msg);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
				} catch (IOException ignore) {
					System.out.println(ignore.getMessage());
				}
			}
		}
	}
}
