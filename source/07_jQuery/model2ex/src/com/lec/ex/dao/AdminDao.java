package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.AdminDto;

public class AdminDao {
	private static final int SUCCESS = 1;
	private static final int FAIL = 0;
	private DataSource ds;
	public AdminDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// (1) admin 로그인
	public int loginAdmin(String aid, String apw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM ADMIN WHERE aID=? AND aPW=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			pstmt.setString(2, apw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// (2) admin aid로 AdminDto 가져오기 (로그인 후 세션에 넣을 용도)
	public AdminDto getAdmin(String aid) {
		AdminDto admin = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM ADMIN WHERE aID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String apw = rs.getString("apw");
				String aname = rs.getString("aname");
				admin = new AdminDto(aid, apw, aname);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return admin;
	}
}
