package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupermarketDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1; // 변하지 않는 상수이기 때문에 final
	public final static int FAIL = 0;
	private static SupermarketDAO INSTANCE;
	public static SupermarketDAO getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SupermarketDAO();
		}
		return INSTANCE;
	}
	private SupermarketDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public int insertMember(SupermarketDTO dto) {
		int result = FAIL;
		Connection	conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO SCUSTOMER VALUES (CID_NO_SQ.NEXTVAL, ?, ?, NULL, NULL, (SELECT MLEVEL FROM SLEVEL WHERE HPOINT < 50000))";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCtel());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
}
