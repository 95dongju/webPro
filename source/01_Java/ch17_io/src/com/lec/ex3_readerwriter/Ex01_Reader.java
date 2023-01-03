package com.lec.ex3_readerwriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1�ܰ�. ��Ʈ�� ��ü ���� (���� ����)
			while(true) { //2�ܰ�. ������ �б�
				int i = reader.read(); // 2����Ʈ ����
				if(i == -1) break;
				System.out.print((char)i +"("+i+")");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println();
		} finally {
			try {
				if (reader!=null) reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
