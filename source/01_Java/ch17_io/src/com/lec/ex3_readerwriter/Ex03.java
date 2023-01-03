package com.lec.ex3_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// �����̸��� ������� msg�� �ַܼ� �Է¹��� (����ڰ� X�� ���� ������)
public class Ex03 {
	public static void main(String[] args) {
		Writer writer = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ���� �̸���?");
		String filename = sc.next(); // abc => txtFile/abc.txt
		sc.nextLine(); // ���� ����� �뵵
		try {
			writer = new FileWriter("txtFile/"+filename+".txt");
			while(true) {
				System.out.print("���Ϸ� ����� �޽��� (����:X):");
				String msg = sc.nextLine();
				if(msg.equalsIgnoreCase("x")) break;
				writer.write(msg+"\r\n");
			}
			System.out.println("txtFile/"+filename+".txt ���ϸ����� ���� ���� �Ϸ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
