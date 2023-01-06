package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 부서이름을 입력받아 부서 정보 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("원하는 부서 이름은? : ");
		String dname = sc.next();
		String sql = "SELECT * FROM DEPT WHERE DNAME=UPPER('"+dname+"')";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);
		try {
			Class.forName(driver);// 1. 드라이버
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) { // true면 데이터가 있음 (없으면 else)
				System.out.println("부서번호 : " +rs.getInt("deptno"));
				System.out.println("부서명 : "+dname);
				System.out.println("위치 : "+rs.getString("loc"));
			}else {
				System.out.println("해당 부서 이름이 존재하지 않습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // 1. 드라이버
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
