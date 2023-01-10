package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �Է¹��� �μ���ȣ �ߺ�üũ �� "�ߺ��� �μ���ȣ�� �Է��� �Ұ����մϴ�"
// �μ���, �ٹ��� �Է¹޾� insert
public class Ex2_InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.print("�μ� ��ȣ�� �Է��ϼ��� : ");
			int deptno = sc.nextInt();
			String quary1 = String.format("SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=%d", deptno);
			rs = stmt.executeQuery(quary1);
			rs.next();
			int cnt = rs.getInt("CNT");
			if (cnt != 0) {
				System.out.println("�ߺ��� �μ��Դϴ�");
			}else {
				System.out.println("�μ����� �Է��ϼ��� : ");
				String dname = sc.next();
				System.out.println("�ٹ����� �Է��ϼ��� : ");
				String loc = sc.next();
				String quary2 = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", 
																		deptno, dname, loc);
				int result = stmt.executeUpdate(quary2);
				System.out.println(result>0 ? "�Է¼���" : "�Է½���");
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