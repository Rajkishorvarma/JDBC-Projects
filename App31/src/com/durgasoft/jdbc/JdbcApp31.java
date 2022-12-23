package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp31 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			pst = con.prepareStatement("update emp1 set ESAL= ESAL+ ? where ESAL < ?");
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Bonus Ammount   : ");
			int bonus = Integer.parseInt(br.readLine());
			System.out.println("Salary Range    : ");
			float sal_range = Float.parseFloat(br.readLine());
			
			pst.setInt(1,bonus);
			pst.setFloat(2, sal_range);
			int rowCount = pst.executeUpdate();
			System.out.println("Employee updated  :"+rowCount);
			
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
