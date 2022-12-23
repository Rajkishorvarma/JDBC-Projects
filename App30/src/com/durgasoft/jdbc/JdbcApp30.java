package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp30 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			pst= con.prepareStatement("insert into emp1 values(?,?,?,?)");
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("Employee Number    : ");
				int eno = Integer.parseInt(br.readLine());
				System.out.println("Employee Name      : ");
				String ename = br.readLine();
				System.out.println("Employee Salary    : ");
				Float esal = Float.parseFloat(br.readLine());
				System.out.println("Employee Address   : ");
				String eaddr = br.readLine();
				
				pst.setInt(1, eno);
				pst.setString(2, ename);
				pst.setFloat(3, esal);
				pst.setString(4, eaddr);
				
				int rowCount = pst.executeUpdate();
				if(rowCount == 1) {
					System.out.println(eno+"Employee inserted sucessfully ");
				}else {
					System.out.println("Enployee Insertion Failure ");
				}
				System.out.println("One More Employee[yes/no]?  :");
				String option = br.readLine();
				if(option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					break;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
