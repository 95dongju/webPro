package com.lec.ex3_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt", true); //, true �� ���� ���� �� upand? �ϰ� ������ �����
//			char[] msg = {'��','��','��','��','��'};
//			for(char m : msg) {
//				writer.write(m);
//			}
//		writer.write(msg);
			String msg = "�ȳ��ϼ���, �ڹ�\n �߿� ���� ���� �����ϼ���";
			writer.write(msg);
			msg = "�̹��� �ݿ��Ͽ��� ���� 15������ ���������.\n �����ϰ� �԰� ������";
			writer.write(msg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
