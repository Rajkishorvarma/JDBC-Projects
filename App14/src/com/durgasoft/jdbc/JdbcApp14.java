package com.durgasoft.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","System","rajkishor");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			String data = "";
			data = data +"ENO,ENAME,ESAL,EADDR\n";
			while(rs.next()) {
				data = data +rs.getInt("ENO")+",";
				data = data +rs.getString("ENAME")+",";
				data = data +rs.getFloat("ESAL")+",";
				data = data + rs.getString("EADDR")+"\n";
			}
			fos = new FileOutputStream("E:/Documents/emp.txt");
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("Data transfered in to E:/Documents/emp.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
