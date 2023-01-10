package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class CustomerDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1; // 변하지 않는 상수이기 때문에 final
	public final static int FAIL = 0;
// DAO는 싱글톤으로 구현
	private static CustomerDAO INSTANCE = new CustomerDAO();
	public static CustomerDAO getInstance() {
		
		return INSTANCE;
	}
	// 생성자 함수는 반드시 private (드라이버 로드)
	private CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 회원가입
	public int insertCustomer(CustomerDTO dto) {
		int result = FAIL;
		Connection	conn = null;
		PreparedStatement pstmt = null;
		String insertSql = "INSERT INTO CUSTOMER (CID, CNAME, CTEL) VALUES (CID_NO_SQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCtel());
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
	public int insertCustomer(String cname, String ctel) {
		int result = FAIL;
		Connection	conn = null;
		PreparedStatement pstmt = null;
		String insertSql = "INSERT INTO CUSTOMER (CID, CNAME, CTEL) VALUES (CID_NO_SQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, cname);
			pstmt.setString(2, ctel);
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
	// 2-1. 전화번호 뒷번호로 찾기
	public ArrayList<CustomerDTO> ctelGetCustomers (String searchTel) {
		ArrayList<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String searchNumSql = "SELECT CID," + 
				" SUBSTR(CTEL, 1, 3) || '-' || SUBSTR(CTEL, 4, 4) || '-' || SUBSTR(CTEL, 8,4) \"CTEL\"," + 
				" CNAME, L.LEVELNAME \"LEVELNAME\", CPOINT, CAMOUNT," + 
				" (SELECT HIGH+1000-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) \"FORLEVELUP\"" + 
				" FROM CUSTOMER C, CUS_LEVEL L" + 
				" WHERE C.LEVELNO=L.LEVELNO" + 
				" AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(searchNumSql);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				String levelname = rs.getString("LEVELNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				int forlevelup = rs.getInt("FORLEVELUP");
				dtos.add(new CustomerDTO(cid, ctel, cname, levelname, cpoint, camount, forlevelup));
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
		return dtos;		
	}

	// 3. 구매
	public int buy (int cid, int price) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String buySql = "UPDATE CUSTOMER SET CAMOUNT = CAMOUNT + ?," + 
				" CPOINT = CPOINT + (?*0.05)," + 
				" LEVELNO = (SELECT L.LEVELNO" + 
				" FROM CUSTOMER C, CUS_LEVEL L" + 
				" WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?)" + 
				" WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(buySql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
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
	// --바뀐 고객 정보 출력
	public CustomerDTO getCustomer(int cid) {
		CustomerDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "SELECT CID," + 
				" SUBSTR(CTEL, 1, 3) || '-' || SUBSTR(CTEL, 4, 4) || '-' || SUBSTR(CTEL, 8,4) \"CTEL\"," + 
				" CNAME, L.LEVELNAME, CPOINT, CAMOUNT," + 
				" (SELECT HIGH+1000-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) \"FORLEVELUP\"" + 
				" FROM CUSTOMER C, CUS_LEVEL L" + 
				" WHERE C.LEVELNO=L.LEVELNO" + 
				" AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 검색결과가 있을 경우(cid가 있을 경우), dto에
//				private int cid = ;
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				String levelname = rs.getString ("LEVELNAME");
				int forlevelup = rs.getInt("FORLEVELUP");
				dto = new CustomerDTO(cid, ctel, cname, levelname, cpoint, camount, forlevelup);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally  {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	return dto;
	}
	
	//--levelName들 정보 추출
	public ArrayList<String> getLevelNames() {
		ArrayList<String> levelNames = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { //전화번호가 여러 개 나올 수도 있으니 while문에 넣기
				levelNames.add(rs.getString("LEVELNAME"));
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
		return levelNames;
	}
	public ArrayList<CustomerDTO> levelNameGetCustomers(String levelName){
		ArrayList<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = "SELECT CID, SUBSTR(CTEL, 1, 3) || '-' || SUBSTR(CTEL, 4, 4) || '-' || SUBSTR(CTEL, 8,4) \"CTEL\", CNAME, LEVELNAME, CPOINT, CAMOUNT, HIGH+1-CAMOUNT \"FORLEVELUP\"" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=?" + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				String levelname = rs.getString("LEVELNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				int forlevelup = rs.getInt("FORLEVELUP");
				dtos.add(new CustomerDTO(cid, ctel, cname, levelname, cpoint, camount, forlevelup));
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
		return dtos;
	}
	public ArrayList<CustomerDTO> getCustomer(){
		ArrayList<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = "SELECT CID, SUBSTR(CTEL, 1, 3) || '-' || SUBSTR(CTEL, 4, 4) || '-' || SUBSTR(CTEL, 8,4) \"CTEL\", CNAME, LEVELNAME, CPOINT, CAMOUNT, HIGH+1-CAMOUNT \"FORLEVELUP\"" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				String levelname = rs.getString("LEVELNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				int forlevelup = rs.getInt("FORLEVELUP");
				dtos.add(new CustomerDTO(cid, ctel, cname, levelname, cpoint, camount, forlevelup));
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
		return dtos;
	}
	public int deleteCustomer (String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
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
