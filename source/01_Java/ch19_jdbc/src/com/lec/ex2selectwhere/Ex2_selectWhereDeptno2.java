package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �޾� �μ������� ����ϰ�, �ش� �μ��� ��������� ���
	// 1. �ش�μ���ȣ�� ���� ��� : �������� �ʴ� �μ��Դϴ�
	// 2. �ش�μ���ȣ�� �ִ� ��� : �μ������� ���
		// 2-1. �ش�μ������ �ִ� ��� : ��������� ��� (���, �̸�, �޿�, ����̸�)
		// 2-2. �ش�μ������ ���� ��� : �ش�μ� ����� �����ϴ�
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�μ� ��ȣ�� �Է��ϼ���: ");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sqlemp = "SELECT E.EMPNO, E.ENAME, E.SAL, M.ENAME MANAGER"
			    +" FROM EMP E, EMP M"
			    +" WHERE E.MGR=M.EMPNO AND M.DEPTNO=" +deptno;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+"�� �μ� ������ ������ �����ϴ�");
				System.out.println("�μ���: " +dname);
				System.out.println("�μ���: " +loc);
				rs.close();
				rs = stmt.executeQuery(sqlemp);
				if (rs.next()){
					System.out.println("���\t�̸�\t�޿�\t����̸�");
					do {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							int sal = rs.getInt("sal");
							String manager = rs.getString("manager");
							System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+manager);
					}while(rs.next());
				}else {
					System.out.println("�ش�μ� ����� �����ϴ�");
				}
			}else {
				System.out.println("�������� �ʴ� �μ��Դϴ�");
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
