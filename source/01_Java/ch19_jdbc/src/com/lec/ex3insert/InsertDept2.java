package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 입력받은 부서번호 중복체크 후 "중복된 부서번호는 입력이 불가능합니다"
// 부서명, 근무지 입력받아 insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("부서 번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		String quary1 = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
		quary1 = String.format("SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=%d", deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(quary1);
			if (rs.getInt("CNT") == 0) {
				System.out.println("부서명을 입력하세요 : ");
				String dname = sc.next();
				System.out.println("근무지를 입력하세요 : ");
				String loc = sc.next();
				String quary2;
				quary2 = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(quary2);
				System.out.println(result>0 ? "입력성공" : "입력실패");
			}else {
				System.out.println("중복된 부서입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
