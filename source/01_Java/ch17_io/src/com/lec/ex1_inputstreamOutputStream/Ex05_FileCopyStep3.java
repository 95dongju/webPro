package com.lec.ex1_inputstreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// JSP�� String���� ����÷�ΰԽ��� �ۼ��� copy�� ����
public class Ex05_FileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.01.01���� ���۽��������� �и����� (�ð� ����ϴ� ���)
		InputStream is = null;
		OutputStream os = null;
		try {
			File originalFile = new File("d:\\Ju\\note\\bts.mp4"); //������ ����Ű�� ��ü
			is = new FileInputStream(originalFile);
			os = new FileOutputStream("d:/Ju/note/bts_copy.mp4");
			byte[] bs = new byte[(int)originalFile.length()];  //������ ũ�⸸ŭ byte ����. 10MB �̸����� �ø��� �Ұű� ������ int���� �������
			int cnt = 0;
			while(true) { // 2���� ����
				cnt++;
				int count = is.read(bs); //2. read(bs�� �д´�) & write :
				if(count == -1) break;
				os.write(bs, 0, count); //1k�� �� ���� �������� �ʱ� ������ bs�� �ϸ� �ȵ�. (bs�� �ϸ� 1k�� �� ä�� write��
				// bs �迭�� 0�� idx���� count ����Ʈ��ŭ write
			}
			System.out.println(cnt+"�� while�� �����Ͽ� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("read & writer ����: "+e.getMessage());
		} finally {
			try {
				if(os!=null) os.close(); //3. ���� �ݱ� (��Ʈ�� ��ü ����)
				if(is!=null) is.close(); // ��Ʈ�� ��ü�� ���� ���� ��Ʈ�� ��ü�� ���� ������ �ݴ�� �ݴ� �� �Ϲ���
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}//try - catch - finally
		long end = System.currentTimeMillis(); // 1970.01.01 ~ ������ ���������� �и����� (end - start)
		System.out.println(end-start);
	}// main
}
