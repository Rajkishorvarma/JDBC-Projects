package com.durgasoft.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
public class JdbcApp34 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			pst = con.prepareStatement("insert into student values(?,?,?,?,?)");
			pst.setInt(1,111);
			pst.setString(2,"shani");
			pst.setString(3,"hyd");
			java.sql.Date dob = java.sql.Date.valueOf("1999-05-04");
			pst.setDate(4,dob);
			Date d1 = new Date();
			long val = d1.getTime();
			java.sql.Date doj = new java.sql.Date(val);
			pst.setDate(5, doj);
			int rowCount = pst.executeUpdate();
			if (rowCount == 1) {
				System.out.println("Student inserted Successfully ");
			}else {
				System.out.println("Student Insertion Failure ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
