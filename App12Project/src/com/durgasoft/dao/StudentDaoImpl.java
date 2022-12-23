package com.durgasoft.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.durgasoft.beans.Student;
import com.durgasoft.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student std) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where sid = "+std.getSid());
			boolean b = rs.next();
			if (b== true) {
				status = "student existed Already";
			}else {
				int rowCount = st.executeUpdate("insert into student values("+std.getSid()+",'"+std.getSname()+"','"+std.getSaddr()+"')");
				if(rowCount == 1) {
					status = "Student Insersition success";
				}else {
					status = "Student insersition failure";
				}
			}
		} catch (Exception e) {
			status = "Student Insersition Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where sid = "+sid+"");
			boolean b = rs.next();
			if(b== true) {
				std = new Student();
				std.setSid(rs.getString("sid"));
				std.setSname(rs.getString("sname"));
			    std.setSaddr(rs.getString("saddr"));
			}else {
				std = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String update(Student std) {
		String status= "";
		try {
			Connection con =ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("update student set sname = '"+std.getSname()+"', saddr = '"+std.getSaddr()+"' where sid = "+std.getSid()+"");
			if(rowCount == 1) {
				status = " Student Updation Success ";
			}else {
				status = " Student Updation failure ";
			}
		} catch (Exception e) {
			System.out.println("Student Updation Failure");
			e.printStackTrace();
		}
		return status;
	} 

	@Override
	public String delete(String sid) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("delete from student where sid ="+sid+"");
			if(rowCount == 1) {
				status = "Student Deleted Successfully ";
			}else {
				status = "Student Deletion Failure ";
			}
		} catch (Exception e) {
			System.out.println("Student Deletion Failure  ");
			e.printStackTrace();
		}
		return status;
	}

}
