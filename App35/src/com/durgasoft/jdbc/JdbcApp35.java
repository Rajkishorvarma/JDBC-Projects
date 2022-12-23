package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp35 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			pst= con.prepareStatement("select * from student where sid = ?");
			br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Student id ");
			int sid = Integer.parseInt(br.readLine());
			pst.setInt(1, sid);
			System.out.println("Student Details  ");
			System.out.println("SID\t SNAME\t SADDR\t  DOB\t \t  DOJ");
			rs= pst.executeQuery();
			boolean b= rs.next();
			if(b == true) {
				System.out.println("-----------------------------------------------------");
				System.out.print(rs.getInt("sid")+"\t");
				System.out.print(rs.getString("sname")+"\t");
				System.out.print(rs.getString("saddr")+"\t");
				System.out.print(rs.getDate("dob")+"\t");
				System.out.print(rs.getDate("doj")+"\n");
			}else {
				System.out.println("Student not Existed ");
			}
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
