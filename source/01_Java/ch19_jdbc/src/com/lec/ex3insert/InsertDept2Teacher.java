package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �Է¹��� �μ���ȣ �ߺ�üũ �� "�ߺ��� �μ���ȣ�� �Է��� �Ұ����մϴ�"
// �μ���, �ٹ��� �Է¹޾� insert
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
			System.out.print("�μ� ��ȣ�� �Է��ϼ��� : ");
			int deptno = sc.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("CNT");
			if (cnt != 0) {
				System.out.println("�ߺ��� �μ��Դϴ�");
			}else {
				System.out.println("�μ����� �Է��ϼ��� : ");
				String dname = sc.next();
				System.out.println("�ٹ����� �Է��ϼ��� : ");
				String loc = sc.next();
				rs.close(); // pstmt�� �ݱ� ���ؼ� rs ���� ����
				pstmt.close(); // pstmt�� �ݰ� ���ο� pstmt ���� (�Ʒ�)
				pstmt = conn.prepareStatement(quary2);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "�Է¼���" : "�Է½���");
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
