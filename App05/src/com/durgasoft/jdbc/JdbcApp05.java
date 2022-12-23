package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp05 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner scanner=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "rajkishor");
			st = con.createStatement();
			scanner = new Scanner(System.in);
			System.out.println("Salary range : ");
			float salRange = scanner.nextFloat();
			int rowCount = st.executeUpdate("delete from emp1 where esal < "+salRange);
			System.out.println("No Of Employee Deleted : "+rowCount);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				con.close();	
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}

}
