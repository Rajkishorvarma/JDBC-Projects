package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp28 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs= st.executeQuery("select * from emp1");
			while(rs.next()) {
				float esal= rs.getFloat("ESAL");
				if(esal<10000) {
					float new_sal = esal-500;
					rs.updateFloat(3, new_sal);
					rs.updateRow();
					System.out.println(rs.getInt("ENO")+"Employee Updated successfully");
				}
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
