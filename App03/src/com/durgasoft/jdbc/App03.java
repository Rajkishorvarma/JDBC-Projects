package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class App03 {

	public static void main(String[] args) {
		Connection con =null;
		Statement st =null;
		BufferedReader br =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "rajkishor");
			st= con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Employee no      : ");
				int eno = Integer.parseInt(br.readLine());
				System.out.println("Employee Name    : ");
				String ename = br.readLine();
				System.out.println("Employee Salary  : ");
				Float esal = Float.parseFloat(br.readLine());
				System.out.println("Employee Address : ");
				String eadd = br.readLine();
				
				String query = "insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eadd+"')";
				st.executeUpdate(query);
				System.out.println("Employee inserted Successfully");
				System.out.println("One more Employee [yes/no]?  :");
				String option =br.readLine();
				if(option.equalsIgnoreCase("yes")) {
					continue;
				
				}
				else {
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
