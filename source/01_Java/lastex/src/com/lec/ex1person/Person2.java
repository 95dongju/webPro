package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection 			conn  	 = null;
		PreparedStatement	pstmt 	 = null;
		ResultSet			rs	  	 = null;
		Statement			stmt 	 = null;
		String insert = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME=?), ?, ?, ?)";
		String jobsearch = "SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT  pNAME || '(' || pNO || '번)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT \"TOT\" FROM PERSON P, JOB J" + 
				" WHERE P.jNO=J.jNO ORDER BY TOT DESC) A" + 
				" WHERE jNAME = ?";
		String scorelist = "SELECT *" + 
				" FROM (SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT pNAME || '(' || pNO || '번)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT \"TOT\" FROM PERSON P, JOB J" + 
				" WHERE P.jNO=J.jNO ORDER BY TOT DESC) A)";
		String jobname = "SELECT jNAME FROM JOB";
		ArrayList<String> jobs = new ArrayList<String>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(jobname);
			
			while (rs.next()) {
				jobs.add(rs.getString("jName"));
			}
			System.out.println("직업 목록");
			for (int idx=0; idx<jobs.size(); idx++) {
				System.out.println(jobs.get(idx));
			}
			rs.close();
			stmt.close();
			while (true) {
				System.out.println("데이터를 입력하려면 (1)번\n"
						+ "직업을 검색하여 점수를 등수별로 출력하려면 (2)번\n"
						+ "모든 정보를 등수별로 출력하려면 (3)번을 누르세요\n");
				int you = sc.nextInt();
				if (you == 1) {
					System.out.print("이름을 입력하세요: ");
					String pname = sc.next();
					System.out.print("직업을 입력하세요: ");
					String jname = sc.next();
					System.out.print("국어 점수를 입력하세요: ");
					int kor = sc.nextInt();
					System.out.print("영어 점수를 입력하세요: ");
					int eng = sc.nextInt();
					System.out.print("수학 점수를 입력하세요: ");
					int mat = sc.nextInt();
					pstmt = conn.prepareStatement(insert);
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "입력 성공" : "입력 실패");
					pstmt.close();
				} else if (you == 2) {
					pstmt = conn.prepareStatement(jobsearch);
					System.out.print("검색하고자 하는 직업을 입력하세요: ");
					String enterjob = sc.next();
					pstmt.setString(1, enterjob);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t 이름\t 직업\t 국어\t 영어\t 수학\t 총점");
						do {
							int rank = rs.getInt("RN");
							String pname = rs.getString("pName");
							String pjob = rs.getString("jName");
							int kor = rs.getInt("KOR");
							int eng = rs.getInt("ENG");
							int mat = rs.getInt("MAT");
							int tot = rs.getInt("TOT");
							System.out.printf("%d\t %s\t %s\t %d\t %d\t %d\t %d\n", rank, pname, pjob, kor, eng, mat, tot);
						} while (rs.next());
					}else {
						System.out.println("검색한 직업이 없습니다.");
					}
					rs.close();
					pstmt.close();
				} else if (you == 3) {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(scorelist);
					while (rs.next()) {
						System.out.println("등수\t 이름\t\t 직업\t 국어\t 영어\t 수학\t 총점");
						int rank = rs.getInt("RN");
						String pname = rs.getString("pName");
						String pjob = rs.getString("jName");
						int kor = rs.getInt("KOR");
						int eng = rs.getInt("ENG");
						int mat = rs.getInt("MAT");
						int tot = rs.getInt("TOT");
						System.out.printf("%d\t %s\t %s\t %d\t %d\t %d\t %d\n", rank, pname, pjob, kor, eng, mat, tot);
					}
					rs.close();
					stmt.close();
				} else {
					System.out.println("잘못 입력하셨습니다.");
				} 
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sc.close();
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
