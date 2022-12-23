package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class JdbcApp02 {

	public static void main(String[] args)throws Exception {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","rajkishor");
	Statement st = con.createStatement();
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Table Name  : ");
	String tname = br.readLine();
	String query = "create table "+tname+"(";
	String primaryKeys = "";
	int primaryKeyCount = 0;
	while (true) {
		System.out.print("Column Name   : ");
		String colName = br .readLine();
		System.out.print("Column Type : ");
		String colType =br.readLine();
		System.out.print("Column Size : ");
		int colSize= Integer.parseInt(br.readLine());
		query = query + colName + " " + colType + "(" + colSize + ")";
		System.out.print("Is it Primary key [Yes/No]? : ");
		String primaryKeyOption = br .readLine();
		if(primaryKeyOption.equalsIgnoreCase("yes"))
		{
			if(primaryKeyCount == 0)
			{
				primaryKeys = primaryKeys + colName;
				primaryKeyCount = primaryKeyCount + 1;
			}else {
				primaryKeys = primaryKeys + "," + colName;
			}
		}
		System.out.println("One More Column [Yes/No]? ");
		String columnOption = br.readLine();
		if(columnOption.equalsIgnoreCase("yes")) {
			query = query + ",";
			continue;
		}else {
			query = query + "," + " primary key(" + primaryKeys + "))";
			break;
		}
	} 
	System.out.println(query);
	st.executeUpdate(query);
	System.out.println("Table "+tname+" Created Successfully");
	st.close();
	con.close();

	}

}
