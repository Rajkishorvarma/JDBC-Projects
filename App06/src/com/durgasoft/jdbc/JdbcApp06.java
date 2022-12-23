package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp06 {

	public static void main(String[] args) {
		Connection con= null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system","rajkishor");
			st = con.createStatement();
			int rowCount1 = st.executeUpdate("create table emp10(ENO number(10) primary key, ENAME varchar2(10))");
			System.out.println(rowCount1);
			int rowCount2 = st.executeUpdate("drop table emp10");
			System.out.println(rowCount2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
