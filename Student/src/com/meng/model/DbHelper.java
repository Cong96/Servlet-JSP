package com.meng.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {

	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL = "jdbc:oracle:thin:@10.18.1.133:1526:ADEV";
	private static final String DBUSER = "ulprdread";
	private static final String DBPASS = "Uat12345";
	private static Connection conn = null;

	public static Connection getConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			throw e;
		}
		return conn;
	}

}