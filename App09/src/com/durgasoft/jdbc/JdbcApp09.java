package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp09 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
			st = con.createStatement();
			boolean b = st.execute("update emp1 set ESAL = ESAl + 500 where ESAl < 10000");
			System.out.println(b);
			int rowCount = st.getUpdateCount();
			System.out.println("Record Updated  : "+rowCount);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
