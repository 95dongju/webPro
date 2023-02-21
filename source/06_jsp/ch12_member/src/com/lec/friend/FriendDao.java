package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static FriendDao instance = new FriendDao();
	public static FriendDao getInstance() {
		return instance;
	};
	private FriendDao() {};
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public int addFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND(NO, NAME, TEL) VALUES (FRIEND_NO_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS? "등록 성공" : "등록 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("등록 실패: " + dto);
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public ArrayList<FriendDto> friendList(){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public ArrayList<FriendDto> getSchFriends(String schName, String schTel){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setString(2, schTel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}
