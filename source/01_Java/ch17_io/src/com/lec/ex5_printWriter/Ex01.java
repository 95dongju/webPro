package com.lec.ex5_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		OutputStream os = null; // 기본스트림
		Writer writer = null; // 기본스트림
		PrintWriter printWriter = null; // 보조스트림
		try {
			// 1. PrintWriter : OutputStream의 보조스트림
//			os = new FileOutputStream("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(os); // printwriter는 os가 기본 스트림
//			// 2. printWriter : Writer의 보조 스트림
//			writer = new FileWriter("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(writer);
			// 3. PrintWriter 기본 스트림처럼 사용
//			printWriter = new PrintWriter ("txtFile/outTest.txt", true); // , true가 안됨 //append 불가
			
			
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\n반갑습니다");
			System.out.print("print는 자동개행이 안됨. 그래서 개행 추가 \n");
			printWriter.print("print는 자동개행이 안됨. 그래서 개행 추가 \n");
			System.out.printf("%s %3d %3d %5.1f\n", "홍길동", 95,94,94.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "홍길동", 95,94,94.5);
			System.out.printf("%s %3d %3d %5.1f\n", "신길동", 100,99,99.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "신길동", 100,99,99.5);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(printWriter!=null) printWriter.close(); // try catch 필요없음
//				if(os!=null) os.close();
				if(writer!=null) writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}
