package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 입력받은 부서번호 중복체크 후 "중복된 부서번호는 입력이 불가능합니다"
// 부서명, 근무지 입력받아 insert
public class InsertDept2Teacher {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String quary1 = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String quary2 = "INSERT INTO DEPT VALUES (?, ?, ?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(quary1);
			System.out.print("부서 번호를 입력하세요 : ");
			int deptno = sc.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("CNT");
			if (cnt != 0) {
				System.out.println("중복된 부서입니다");
			}else {
				System.out.println("부서명을 입력하세요 : ");
				String dname = sc.next();
				System.out.println("근무지를 입력하세요 : ");
				String loc = sc.next();
				rs.close(); // pstmt를 닫기 위해서 rs 먼저 닫음
				pstmt.close(); // pstmt를 닫고 새로운 pstmt 생성 (아래)
				pstmt = conn.prepareStatement(quary2);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "입력성공" : "입력실패");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
