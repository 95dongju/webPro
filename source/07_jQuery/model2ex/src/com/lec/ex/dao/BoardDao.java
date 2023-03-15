package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	private final int SUCCESS = 1;
	private final int FAIL = 0;
	private DataSource ds;
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// (1) 글 목록
	public ArrayList<BoardDto> boardList(int startRow, int endRow){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT B.*, M.mNAME FROM(SELECT ROWNUM RN, A.* FROM(SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A) B, MVC_MEMBER M WHERE RN BETWEEN ? AND ? AND B.mID = M.mID";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int fid = rs.getInt("fid");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String ftitle = rs.getString("ftitle");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 Timestamp frdate = rs.getTimestamp("frdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep = rs.getInt("fstep");
				 int findent = rs.getInt("findent");
				 String fip = rs.getString("fip");
				 list.add(new BoardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}
	// (2) 글 갯수
	public int totBoard() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	// (3-1) 글쓰기 (원글)
	public int write(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)" + 
				"    VALUES (fNO_SEQ.NEXTVAL, ?, ?, ?, ?, fNO_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFip());
			pstmt.executeUpdate();
			result = SUCCESS;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	// (3-2-1) 글쓰기 (답변 전 단계)
	private void preReplyStep(int fgroup, int fstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSTEP = fSTEP + 1" + 
				"            WHERE fGROUP = ? AND fSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// (3-2-2) 글쓰기 (답변)
	public int reply(BoardDto dto) {
		preReplyStep(dto.getFgroup(), dto.getFstep());
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)\r\n" + 
				"    VALUES (fNO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFgroup());
			pstmt.setInt(7, dto.getFstep()+1);
			pstmt.setInt(8, dto.getFindent()+1);
			pstmt.setString(9, dto.getFip());
			pstmt.executeUpdate();
			result = SUCCESS;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	// (4) 조회수
	public void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE fID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// (5) 글번호로 글 전체 내용 가져오기
	public BoardDto getBoard(int fid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT B.*, M.mNAME FROM FILEBOARD B, MVC_MEMBER M WHERE B.mID = M.mID AND fID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String ftitle = rs.getString("ftitle");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 Timestamp frdate = rs.getTimestamp("frdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep = rs.getInt("fstep");
				 int findent = rs.getInt("findent");
				 String fip = rs.getString("fip");
				 dto = new BoardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// (6) 글 수정
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fTITLE = ?," + 
				"                    fCONTENT = ?," + 
				"                    fFILENAME = ?," + 
				"                    fRDATE = SYSDATE," + 
				"                    fIP = ?" + 
				"                WHERE fID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFtitle());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFip());
			pstmt.setString(5, dto.getMid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	public int deleteBoard(int fid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	public int deleteAll(String mid) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE mID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cnt;
	}
}
