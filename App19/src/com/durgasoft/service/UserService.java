package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status="";
	public UserService() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "rajkishor");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String checkLogin(String uname, String upwd) {
		try {
			rs = st.executeQuery("select * from regUsers where uname= '"+uname+"' and upwd = '"+upwd+"'");
			boolean b = rs.next();
			if(b == true) {
				status = "User Login Success";
			}else {
				status = "User Login Failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}








