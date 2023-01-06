package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "SELECT * FROM EMP";
		Connection conn = null;
		Statement stmt 	= null;
		ResultSet rs 	= null;
		try {
			Class.forName(driver); // 1. 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3. SQL 전송객체
			rs 	 = stmt.executeQuery(sql); // 4,5. SQL 전송+전송결과 받기
			if (rs.next()) { // select 결과가 1행 이상
				System.out.println("사번\t이름\t직책\t상사사번\t입사일\t급여\t상여\t부서번호");
				do {
					int empno 		= rs.getInt(1);
					String ename	= rs.getString("ename");
					String job		= rs.getString("job");
					String mgr		= rs.getString("mgr");
					Date hiredate 	= rs.getDate("hiredate");
					// String hiredate = rs.getString("hiredate");  
					Timestamp hiredate1 = rs.getTimestamp("hiredate"); // 시간까지 명확하게 명시하기 위해서는 timestamp로 받아야 함
					int sal			= rs.getInt("sal");
					int comm		= rs.getInt("comm");
					int deptno 		= rs.getInt("deptno");
					System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}while(rs.next());
			}else { // select 결과가 없는 경우
				System.out.println("등록된 사원 정보가 없습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try { // 7. 연결 해제
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
