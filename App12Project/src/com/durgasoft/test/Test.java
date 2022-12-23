package com.durgasoft.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.durgasoft.beans.Student;
import com.durgasoft.factory.StudentServiceFactory;
import com.durgasoft.service.StudentService;

public class Test {

	public static void main(String[] args) {
		try {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("-------------------------");
				System.out.println("1  Add");
				System.out.println("2  Search");
				System.out.println("3  Update");
				System.out.println("4  Delete");
				System.out.println("5  Exit");
				System.out.println("Your choice [1,2,3,4,5]  : ");
				int option = Integer.parseInt(br.readLine());
				String sid="", sname = "", saddr = "";
				StudentService studentService = StudentServiceFactory.getStudentService();
				Student std = null;
				switch (option) {
				case 1:
						System.out.println("---------------------------");
						System.out.println("Student  id     : ");
						sid = br.readLine();
						System.out.println("Student name    : ");
						sname = br.readLine();
						System.out.println("Student Address : ");
						saddr = br.readLine();
						std = new Student();
						std.setSid(sid);
						std.setSname(sname);
						std.setSaddr(saddr);
						String status = studentService.addStudent(std);
						System.out.println("Status   : "+status);
						
					break;
				case 2:
					System.out.print("Student ID  : ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if(std == null) {
						System.out.println("Student Not Existed");
					}else {
						System.out.println("Student Details");
						System.out.println("--------------------------");
						System.out.println("Student Id      : "+std.getSid());
						System.out.println("Student Name    : "+std.getSname());
						System.out.println("Student Adresss : "+std.getSaddr());
						
					}
					break;
				case 3:
					System.out.println("Student Id   : ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if (std == null) {
						System.out.println("Status : Student not Existed ");
					} else {
						System.out.println("Student Name [old name :"+std.getSname()+"] : ");
						String sname_new = br.readLine();
						if(sname_new == null || sname_new.equals("")) {
							sname_new =std.getSname();
						}
						System.out.println("Student Address [old Address :"+std.getSaddr()+"] : ");
						String saddr_new = br.readLine();
						if(saddr_new == null || saddr_new.equals("")) {
							saddr_new =std.getSaddr();
						}
						Student std_new = new Student();
						std_new.setSid(sid);
						std_new.setSname(sname_new);
						std_new.setSaddr(saddr_new);
						status = studentService.updateStudent(std_new);
						System.out.println("Status  : "+status);
						
					}
					break;
				case 4:
					System.out.println(" Student Id  : ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if(std == null){
						System.out.println("Status  : Student Not Existed  ");
					}else {
						status = studentService.deleteStudent(sid);
						System.out.println("Status  "+status);
						
					}
					break;
				case 5:
					System.out.println("***********ThanQ for using Student Application**********");
					System.exit(0);
					break;

				default:
					System.out.println("provide number from 1,2,3,4,5 ");
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
