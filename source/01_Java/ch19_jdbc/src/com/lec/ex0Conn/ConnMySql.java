package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		Connection conn = null; // conn 을 null 로 초기화
		try {
			Class.forName(driver);		// 1. 드라이버 로드
			System.out.println("드라이버 연결 성공");
			// 2. DB 연결객체
			conn = DriverManager.getConnection(url, "root", "mysql"); // url, 계정, 비밀번호 입력 
			System.out.println("MYSQL 연결 성공");
			// 3 ~ 6단계 
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패: " +e.getMessage()); // 드라이버가 없을 때 예외 발생
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // SQL 연결 오류시 예외 발생
		} finally {
			try {
				// 7단계: DB 연결 객체 해제 (반드시 해제해야 함)
				if(conn!=null) conn.close(); 
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
