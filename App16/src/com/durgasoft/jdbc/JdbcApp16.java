package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp16 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "rajkishor");
			st = con.createStatement();
			rs= st.executeQuery("select * from emp1");
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();
			System.out.println("No of column  "+count);
			for(int i=1;i<=count;i++) {
				System.out.println("Column name  "+md.getColumnName(i));
				System.out.println("Column type  "+md.getColumnTypeName(i));
				System.out.println("Column Size  "+md.getColumnDisplaySize(i));
				System.out.println("--------------------------------");
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
