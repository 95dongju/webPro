package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 수정할 부서번호를 받아 존재하는 부서번호인지 확인 후, 
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.print("수정할 부서 번호는?");
			while (true) {
				int deptno = sc.nextInt();
				String sql = String.format("SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=%d", deptno);
				rs = stmt.executeQuery(sql);
				rs.next();
				int cnt = rs.getInt("CNT");
				if (cnt == 0) {
					System.out.println("부서 번호가 존재하지 않습니다.");
					continue;
				} else {
					System.out.print("수정할 부서명은? : ");
					String dname = sc.next();
					System.out.print("수정할 위치는? : ");
					String loc = sc.next();
					String updatesql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d",
												dname, loc, deptno);
					int result = stmt.executeUpdate(updatesql);
					System.out.println(result > 0 ? deptno+"번 부서정보 수정 성공" : "해당 부서가 없어 수정 실패");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
