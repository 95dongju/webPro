package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 메소드1, 메소드2, 메소드3, 메소드4
public class PersonDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1; // 변하지 않는 상수이기 때문에 final
	public final static int FAIL = 0;
	private static PersonDAO INSTANCE;
	public static PersonDAO getInstance() {
		if(INSTANCE==null) {
		INSTANCE = new PersonDAO();
		}
		return INSTANCE;
	}
	private PersonDAO() { // 생성자 함수는 싱글톤
		try {
			Class.forName(driver); // 1단계는 생성자에서 1번만 실행함
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	} 
	// 1번 기능 DTO(이름, 직업명, 국영수)를 받아 DB에 insert 하고 SUCCESS/FAIL을 return
	public int insertPerson(PersonDTO dto) {
		int result = FAIL;
		// DB insert 하고 결과를 result에 할당
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		String sql = "INSERT INTO PERSON"
				+ " VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME=?),"
				+ " ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			pstmt = conn.prepareStatement(sql); // 3
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "성공" : "실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	// 2번 기능 직업명을 받아 DB에 select한 결과를 ArrayList<PersonDTO>로 return
	public ArrayList<PersonDTO> selectJname(String jname){
		ArrayList<PersonDTO> dtos = new ArrayList<PersonDTO>();
		// DB 결과를 dtos에 add
		Connection			conn  = null;
		PreparedStatement	pstmt = null;
		ResultSet			rs	  = null;
		String sql = "SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT  pNAME || '(' || pNO || '번)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT TOT" + 
				" FROM PERSON P, JOB J" + 
				" WHERE P.jNO=J.jNO ORDER BY TOT DESC) A" + 
				" WHERE jNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("RN");
				String pname = rs.getString("pNAME");
//				String jname = rs.getString("jNAME");
				int kor = rs.getInt("KOR");
				int eng = rs.getInt("ENG");
				int mat = rs.getInt("MAT");
				int sum = rs.getInt("TOT");
				dtos.add(new PersonDTO(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 3번 기능 DB에 전체 select한 결과를 ArrayList<PersonDTO>로 return
	public ArrayList<PersonDTO> selectAll(){
		ArrayList<PersonDTO> dtos = new ArrayList<PersonDTO>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs	= null;
		String sql = "SELECT *" + 
				" FROM (SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT pNAME || '(' || pNO || '번)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT TOT" + 
				" FROM PERSON P, JOB J" + 
				" WHERE P.jNO=J.jNO ORDER BY TOT DESC) A)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				// while 문이 끝까지 갔다가 다시 블럭으로 들어오기 때문에 while문 실행할 때마다 새로운 dto가 만들어짐
				PersonDTO dto = new PersonDTO(); // dto 객체 생성할 때 반드시 while문 안에 있어야 함
				dto.setRank(rs.getInt("RN"));
				dto.setPname(rs.getString("pNAME"));
				dto.setJname(rs.getString("jNAME"));
				dto.setKor(rs.getInt("KOR"));
				dto.setEng(rs.getInt("ENG"));
				dto.setMat(rs.getInt("MAT"));
				dto.setSum(rs.getInt("TOT"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// jname들을 ArrayList<String>로 return
	public ArrayList<String> jnamelist() {
		ArrayList<String> jnames = new ArrayList<String> ();
		Connection			conn 	= null;
		PreparedStatement	pstmt 	= null;
		ResultSet			rs 		= null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames;
	}
}
