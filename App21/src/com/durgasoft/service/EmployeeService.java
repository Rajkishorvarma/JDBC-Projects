package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.durgasoft.beans.Employee;

public class EmployeeService {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		public EmployeeService() {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
				st= con.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public Employee search(int eno) {
			Employee emp =null;
			try {
				rs= st.executeQuery("select * from emp1 where ENO="+eno);
				boolean b=rs.next();
				if(b==true)
				{
					emp = new Employee();
					emp.setEno(rs.getInt("ENO"));
					emp.setEname(rs.getString("ENAME"));
					emp.setEsal(rs.getFloat("ESAL"));
					emp.setEaddr(rs.getString("EADDR"));
				}else {
					emp=null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return emp;
		}
}
