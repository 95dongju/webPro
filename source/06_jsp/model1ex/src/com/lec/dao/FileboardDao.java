package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lect.dto.FileboardDto;

public class FileboardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static FileboardDao instance = new FileboardDao();
	public static FileboardDao getInstance() {
		return instance;
	}
	private FileboardDao() {}
	private Connection getConnection() throws SQLException {
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
	// 1. 게시판 전체글 갯수
	public int getTotalfileboard() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1);
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
		return totalCnt;
	}
	// 2. 글 작성
	public int insertFileboard(FileboardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)" + 
				"    VALUES (fNUM_SEQ.NEXTVAL, ?, ?, ?, ?, ?, fNUM_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
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
	// 3. 글 수정
	public int updateFileboard(FileboardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSUBJECT=?," + 
				"                    fCONTENT=?," + 
				"                    fFILENAME=?," + 
				"                    fPW=?," + 
				"                    cID=?" + 
				"                WHERE fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("글 수정 예외 발생 : " + dto);
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
	// 4. 게시판 글 리스트 (paging)
	public ArrayList<FileboardDto> listBoard(int startRow, int endRow){
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A. * FROM (SELECT * FROM FILEBOARD ORDER BY fREF DESC, fRE_STEP) A) F, CUSTOMER C WHERE F.cID = C.cID AND RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int fnum = rs.getInt("fnum");
				 String cid = rs.getString("cid");
				 String fsubject = rs.getString("fsubject");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 String fpw = rs.getString("fpw");
				 int fhit = rs.getInt("fhit");
				 int fref = rs.getInt("fref");
				 int fre_level = rs.getInt("fre_level");
				 int fre_step = rs.getInt("fre_step");
				 String fip = rs.getString("fip");
				 Date frdate = rs.getDate("frdate");
				 String cname = rs.getString("cname");
				 String cemail = rs.getString("cemail");
				 dtos.add(new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_level, fre_step, fip, frdate, cname, cemail));
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
		return dtos;
	}
	// 5. 글 번호로 글 내용 가져오기
	public FileboardDto getFileboardOneLine(int num) {
		FileboardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM FILEBOARD F, CUSTOMER C WHERE F.cID = C.cID AND fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int fnum = rs.getInt("fnum");
				 String cid = rs.getString("cid");
				 String fsubject = rs.getString("fsubject");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 String fpw = rs.getString("fpw");
				 int fhit = rs.getInt("fhit");
				 int fref = rs.getInt("fref");
				 int fre_level = rs.getInt("fre_level");
				 int fre_step = rs.getInt("fre_step");
				 String fip = rs.getString("fip");
				 Date frdate = rs.getDate("frdate");
				 String cname = rs.getString("cname");
				 String cemail = rs.getString("cemail");
				 dto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_level, fre_step, fip, frdate, cname, cemail);
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
	// 6. 조회수 올리기
	public void hitcountUp(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int deleteFileboard(int fnum, String fpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="DELETE FROM FILEBOARD WHERE fNUM=? AND fPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public void preReplyStep(int fref, int fre_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=? AND fRE_STEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fref);
			pstmt.setInt(2, fre_step);
			int result = pstmt.executeUpdate();
			System.out.println(result==0? "첫 답변입니다":result+"행 step 조정");
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
	public int reply(FileboardDto dto) {
		preReplyStep(dto.getFref(), dto.getFre_step());
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)" + 
				"    VALUES (fNUM_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFref());
			pstmt.setInt(7, dto.getFre_step()+1);
			pstmt.setInt(8, dto.getFre_level()+1);
			pstmt.setString(9, dto.getFip());
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
}
