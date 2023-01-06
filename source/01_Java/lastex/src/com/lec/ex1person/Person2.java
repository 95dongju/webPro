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
				" FROM (SELECT  pNAME || '(' || pNO || '��)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT \"TOT\" FROM PERSON P, JOB J" + 
				" WHERE P.jNO=J.jNO ORDER BY TOT DESC) A" + 
				" WHERE jNAME = ?";
		String scorelist = "SELECT *" + 
				" FROM (SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT pNAME || '(' || pNO || '��)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT \"TOT\" FROM PERSON P, JOB J" + 
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
			System.out.println("���� ���");
			for (int idx=0; idx<jobs.size(); idx++) {
				System.out.println(jobs.get(idx));
			}
			rs.close();
			stmt.close();
			while (true) {
				System.out.println("�����͸� �Է��Ϸ��� (1)��\n"
						+ "������ �˻��Ͽ� ������ ������� ����Ϸ��� (2)��\n"
						+ "��� ������ ������� ����Ϸ��� (3)���� ��������\n");
				int you = sc.nextInt();
				if (you == 1) {
					System.out.print("�̸��� �Է��ϼ���: ");
					String pname = sc.next();
					System.out.print("������ �Է��ϼ���: ");
					String jname = sc.next();
					System.out.print("���� ������ �Է��ϼ���: ");
					int kor = sc.nextInt();
					System.out.print("���� ������ �Է��ϼ���: ");
					int eng = sc.nextInt();
					System.out.print("���� ������ �Է��ϼ���: ");
					int mat = sc.nextInt();
					pstmt = conn.prepareStatement(insert);
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է� ����" : "�Է� ����");
					pstmt.close();
				} else if (you == 2) {
					pstmt = conn.prepareStatement(jobsearch);
					System.out.print("�˻��ϰ��� �ϴ� ������ �Է��ϼ���: ");
					String enterjob = sc.next();
					pstmt.setString(1, enterjob);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t �̸�\t ����\t ����\t ����\t ����\t ����");
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
						System.out.println("�˻��� ������ �����ϴ�.");
					}
					rs.close();
					pstmt.close();
				} else if (you == 3) {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(scorelist);
					while (rs.next()) {
						System.out.println("���\t �̸�\t\t ����\t ����\t ����\t ����\t ����");
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
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
