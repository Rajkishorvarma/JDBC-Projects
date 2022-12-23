package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp24 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs= st.executeQuery("select * from student");
			rs.afterLast();
			rs.previous();
			System.out.println(rs.getInt("sid"));
			rs.beforeFirst();
			rs.next();
			System.out.println(rs.getInt("sid"));
			rs.first();
			System.out.println(rs.getInt("sid"));
			rs.last();
			System.out.println(rs.getInt("sid"));
			rs.first();
			rs.absolute(4);
			System.out.println(rs.getInt("sid"));
			rs.absolute(-4);
			System.out.println(rs.getInt("sid"));
			rs.first();
			rs.relative(3);
			System.out.println(rs.getInt("sid"));
			rs.last();
			rs.relative(-3);
			System.out.println(rs.getInt("sid"));
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
