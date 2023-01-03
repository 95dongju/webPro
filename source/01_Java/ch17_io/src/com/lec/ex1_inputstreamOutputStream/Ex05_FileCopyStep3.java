package com.lec.ex1_inputstreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// JSP나 String에서 파일첨부게시판 작성시 copy할 로직
public class Ex05_FileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.01.01부터 시작시점까지의 밀리세컨 (시간 계산하는 방법)
		InputStream is = null;
		OutputStream os = null;
		try {
			File originalFile = new File("d:\\Ju\\note\\bts.mp4"); //파일을 가르키는 객체
			is = new FileInputStream(originalFile);
			os = new FileOutputStream("d:/Ju/note/bts_copy.mp4");
			byte[] bs = new byte[(int)originalFile.length()];  //파일의 크기만큼 byte 잡음. 10MB 미만으로 올리게 할거기 때문에 int여도 상관없음
			int cnt = 0;
			while(true) { // 2번만 수행
				cnt++;
				int count = is.read(bs); //2. read(bs에 읽는다) & write :
				if(count == -1) break;
				os.write(bs, 0, count); //1k로 딱 나눠 떨어지지 않기 때문에 bs로 하면 안됨. (bs로 하면 1k를 꽉 채워 write함
				// bs 배열을 0번 idx부터 count 바이트만큼 write
			}
			System.out.println(cnt+"번 while문 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("read & writer 오류: "+e.getMessage());
		} finally {
			try {
				if(os!=null) os.close(); //3. 파일 닫기 (스트림 객체 해제)
				if(is!=null) is.close(); // 스트림 객체를 닫을 때는 스트림 객체를 만든 순서의 반대로 닫는 게 일반적
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}//try - catch - finally
		long end = System.currentTimeMillis(); // 1970.01.01 ~ 끝나는 시점까지의 밀리세컨 (end - start)
		System.out.println(end-start);
	}// main
}
