package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// �޼ҵ�1, �޼ҵ�2, �޼ҵ�3, �޼ҵ�4
public class PersonDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1; // ������ �ʴ� ����̱� ������ final
	public final static int FAIL = 0;
	private static PersonDAO INSTANCE;
	public static PersonDAO getInstance() {
		if(INSTANCE==null) {
		INSTANCE = new PersonDAO();
		}
		return INSTANCE;
	}
	private PersonDAO() { // ������ �Լ��� �̱���
		try {
			Class.forName(driver); // 1�ܰ�� �����ڿ��� 1���� ������
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	} 
	// 1�� ��� DTO(�̸�, ������, ������)�� �޾� DB�� insert �ϰ� SUCCESS/FAIL�� return
	public int insertPerson(PersonDTO dto) {
		int result = FAIL;
		// DB insert �ϰ� ����� result�� �Ҵ�
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
			System.out.println(result == SUCCESS ? "����" : "����");
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
	// 2�� ��� �������� �޾� DB�� select�� ����� ArrayList<PersonDTO>�� return
	public ArrayList<PersonDTO> selectJname(String jname){
		ArrayList<PersonDTO> dtos = new ArrayList<PersonDTO>();
		// DB ����� dtos�� add
		Connection			conn  = null;
		PreparedStatement	pstmt = null;
		ResultSet			rs	  = null;
		String sql = "SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT  pNAME || '(' || pNO || '��)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT TOT" + 
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
	// 3�� ��� DB�� ��ü select�� ����� ArrayList<PersonDTO>�� return
	public ArrayList<PersonDTO> selectAll(){
		ArrayList<PersonDTO> dtos = new ArrayList<PersonDTO>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs	= null;
		String sql = "SELECT *" + 
				" FROM (SELECT ROWNUM RN, A.*" + 
				" FROM (SELECT pNAME || '(' || pNO || '��)' \"pNAME\", jNAME, KOR, ENG, MAT, KOR+ENG+MAT TOT" + 
				" FROM PERSON P, JOB J" + 
				" WHERE P.jNO=J.jNO ORDER BY TOT DESC) A)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				// while ���� ������ ���ٰ� �ٽ� ������ ������ ������ while�� ������ ������ ���ο� dto�� �������
				PersonDTO dto = new PersonDTO(); // dto ��ü ������ �� �ݵ�� while�� �ȿ� �־�� ��
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
	// jname���� ArrayList<String>�� return
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
