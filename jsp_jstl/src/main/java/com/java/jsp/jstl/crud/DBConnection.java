package com.java.jsp.jstl.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static int status = 0;
	public final static String DB_DRIVER_CLASS = "org.postgresql.Driver";
	private static String DB_URL = "jdbc:postgresql://localhost:5432/vastpro";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "postgres";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DB_DRIVER_CLASS);
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return con;
	}
}
