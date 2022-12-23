package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp18 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BufferedReader br =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Sql query  : ");
			String query = br.readLine();
			boolean b= st.execute(query);
			if(b==true) {
				rs = st.getResultSet();
				ResultSetMetaData md = rs.getMetaData();
				int count = md.getColumnCount();
				for(int i= 1;i<=count;i++) {
					System.out.print(md.getColumnName(i)+"\t");
				}
				System.out.println();
				System.out.println("-------------------------------");
				while(rs.next()) {
					for(int i=1;i<=count;i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
				}
			}else {
				int rowCount  = st.getUpdateCount();
				System.out.println("Row Count : "+rowCount);
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
