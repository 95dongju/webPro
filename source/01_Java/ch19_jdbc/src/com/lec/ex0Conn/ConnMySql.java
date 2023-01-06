package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		Connection conn = null; // conn �� null �� �ʱ�ȭ
		try {
			Class.forName(driver);		// 1. ����̹� �ε�
			System.out.println("����̹� ���� ����");
			// 2. DB ���ᰴü
			conn = DriverManager.getConnection(url, "root", "mysql"); // url, ����, ��й�ȣ �Է� 
			System.out.println("MYSQL ���� ����");
			// 3 ~ 6�ܰ� 
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����: " +e.getMessage()); // ����̹��� ���� �� ���� �߻�
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // SQL ���� ������ ���� �߻�
		} finally {
			try {
				// 7�ܰ�: DB ���� ��ü ���� (�ݵ�� �����ؾ� ��)
				if(conn!=null) conn.close(); 
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
