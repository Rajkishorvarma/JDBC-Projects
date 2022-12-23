package com.durgasoft.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp23 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
			st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from emp1");
			System.out.println("Employee details in Forwerd Direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("--------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getFloat("esal")+"\t");
				System.out.print(rs.getString("eaddr")+"\n");
			}
			System.out.println();
			System.out.println("Employee Detail in backword Direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("---------------------------------------");
			while (rs.previous()) {
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getFloat("esal")+"\t");
				System.out.print(rs.getString("eaddr")+"\n");
	
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
