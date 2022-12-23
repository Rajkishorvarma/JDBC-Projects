package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp32 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
			pst = con.prepareStatement("delete from emp1 where esal< ?");
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Salary Range : ");
			float sal_range = Float.parseFloat(br.readLine());
			pst.setFloat(1, sal_range);
			int rowCount = pst.executeUpdate();
			System.out.println("Employee deleted  :"+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
