package com.durgasoft.jdbc;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.DriverManager;
public class JdbcApp04 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner scanner = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
			st =con.createStatement();
			scanner = new Scanner(System.in);
			System.out.println("bonus ammount : ");
			int bonus = scanner.nextInt();
			System.out.println(" Salary Range");
			float salRange = scanner.nextFloat();
			int rowCount = st.executeUpdate("update emp1 set ESAL=ESAL+ "+bonus+"where ESAL < "+salRange);
			System.out.println(" Employee updated    : "+rowCount);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
