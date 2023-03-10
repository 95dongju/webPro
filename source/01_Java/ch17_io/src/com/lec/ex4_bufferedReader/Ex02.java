package com.lec.ex4_bufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("읽어올 파일명: ");
		String filename = scanner.next();
		File file = new File("txtFile/"+filename);
		try {
			if(file.exists()) { //파일이 있으면 true 리턴, 파일이 없으면 false 리턴
				reader = new FileReader("txtFile/"+filename);
				br = new BufferedReader(reader); //보조스트림은 기본스트림을 통해 사용하는 것이 안전하다
				while(true) {
					String linedata = br.readLine(); // 한줄씩 읽는다
					if(linedata == null) break;
					System.out.println(linedata);
				}
			}else {
				System.out.println("입력하신 파일은 존재하지 않습니다");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}
