package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// ������ �μ���ȣ�� �޾� �����ϴ� �μ���ȣ���� Ȯ�� ��, 
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection 			conn = null;
		PreparedStatement  pstmt = null;
		ResultSet 			  rs = null;
		String sql = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updatesql = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			while (true) {
				System.out.print("������ �μ� ��ȣ��?");
				int deptno = sc.nextInt();
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery();
				rs.next();
				int cnt = rs.getInt("CNT");
				if (cnt == 0) {
					System.out.println("�μ� ��ȣ�� �������� �ʽ��ϴ�.");
					continue;
				} else {
					System.out.print("������ �μ�����? : ");
					String dname = sc.next();
					System.out.print("������ ��ġ��? : ");
					String loc = sc.next();
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(updatesql);
					pstmt.setString(2, dname);
					pstmt.setString(3, loc);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? deptno+"�� �μ����� ���� ����" : "�ش� �μ��� ���� ���� ����");
					break;
				} 
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
