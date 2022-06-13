package com.java.crud.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDb {
	private static final String DB_DRIVER_CLASS = "org.postgresql.Driver";
	private static final String DB_URl = "jdbc:postgresql://localhost:5432/vastpro";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";
	private static String INSERT = "INSERT INTO studenttest VALUES(?,?,?,?,?);";
	private static String UPDATE = "update studenttest set totalmarks=?,grade=?,where rollnumber=?;";

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName(DB_DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URl, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		System.out.println("Saved");
		return con;
	}

	public static int save(Students s) {
		StudentDb obj = new StudentDb();
		int status = 0;
		try {
			Connection con = obj.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, s.getName());
			ps.setString(2, s.getRollNumber());
			ps.setString(3, s.getGrade());
			ps.setInt(4, s.getAge());
			ps.setInt(5, s.getTotalMarks());
			status = ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int updateStudents(Students e) {
		int status = 0;
		try {
			Connection con = StudentDb.getConnection();
			PreparedStatement ps = con.prepareStatement("update studenttest set totalmarks=?,grade=? where rollnumber=?;");
			
			ps.setString(3, e.getRollNumber());
			
			ps.setString(2, e.getGrade());
			ps.setInt(1, e.getTotalMarks());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static void Studentdelete(String id) {
//		int status = 0;
		try {
			Connection con = StudentDb.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE from studenttest where rollnumber=?;");
			ps.setString(1, id);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return status;
	}

	public static List<Students> getAllStudentId(String grade) {
		List<Students> list = new ArrayList<Students>();
		try {
			Connection con = StudentDb.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT  * from studenttest WHERE grade=?;");
			ps.setString(1, grade);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Students s = new Students();
				s.setId(rs.getInt(6));
				s.setRollNumber(rs.getString(2));
				s.setName(rs.getString(1));
				s.setTotalMarks(rs.getInt(5));
				s.setGrade(rs.getString(3));
				s.setAge(rs.getInt(4));

				list.add(s);

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;

	}

	public static List<Students> getAllStudent() {
		List<Students> list = new ArrayList<Students>();
		try {
			Connection con = StudentDb.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT  * from studenttest;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Students s = new Students();
				s.setId(rs.getInt(6));
				s.setRollNumber(rs.getString(2));
				s.setName(rs.getString(1));
				s.setTotalMarks(rs.getInt(5));
				s.setGrade(rs.getString(3));
				s.setAge(rs.getInt(4));

				list.add(s);

			}

			con.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}
}
