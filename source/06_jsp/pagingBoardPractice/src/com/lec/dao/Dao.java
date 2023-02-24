package com.lec.dao;

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

import com.lec.dto.Dto;

public class Dao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static Dao instance = new Dao();
	public static Dao getInstance() {
		return instance;
	}
	private Dao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}