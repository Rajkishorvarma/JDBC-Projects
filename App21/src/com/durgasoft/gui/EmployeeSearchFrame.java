package com.durgasoft.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.durgasoft.beans.Employee;
import com.durgasoft.service.EmployeeService;

public class EmployeeSearchFrame extends Frame implements ActionListener {
	Label l;
	Button b;
	TextField tf1;
	Employee emp;
	
	 public EmployeeSearchFrame() {
		 this.setVisible(true);
		 this.setSize(500,500);
		 this.setTitle("Employee Search Frame");
		 this.setBackground(Color.green);
		 this.setLayout(new FlowLayout());
		 this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 System.exit(0);
			 }
		});
		 l = new Label("Employee Number");
		 tf1 = new TextField(20);
		 b= new Button("Search");
		 b.addActionListener(this);
		 
		 Font f= new Font("consolas",Font.BOLD,15);
		 l.setFont(f);
		 tf1.setFont(f);
		 b.setFont(f);
		 
		 this.add(l);this.add(tf1);this.add(b);
	 }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			int eno = Integer.parseInt(tf1.getText());
			EmployeeService empService = new EmployeeService();
			emp = empService.search(eno);
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		Font f = new Font("consolas",Font.BOLD,30);
		g.setFont(f);
		if(emp==null) {
			g.drawString("Employee Not Existed", 50, 200);
		}else {
			g.drawString("Employee Number   : "+emp.getEno(),50,200);
			g.drawString("Employee Name     : "+emp.getEname(),50,250);
			g.drawString("Employee Salary   : "+emp.getEsal(),50,300);
			g.drawString("Employee Address  : "+emp.getEaddr(),50,350);
			
		}
	}
}
