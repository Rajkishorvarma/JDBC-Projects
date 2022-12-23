package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeService {
	Connection con =null;
	Statement st =null;
	ResultSet rs = null;
	public EmployeeService() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "rajkishor");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String add(int eno,String ename,float esal,String eaddr) {
		String status = "";
		try {
				rs= st.executeQuery("select * from emp1 where ENO = "+eno);
				boolean b = rs.next();
				if(b==true) {
					status = "Employee Existed Already ";
				}else {
					int rowCount = st.executeUpdate("insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
					if(rowCount ==1) {
						status ="Employee insertion Success";
					}else {
						status = "Employee insertion Failure";
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
