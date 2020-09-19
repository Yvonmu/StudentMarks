package CST172;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

import CST172.conn;
import net.proteanit.sql.DbUtils;

public class Teacher extends JFrame implements ActionListener {
	private JButton btn,b2;
	private JComboBox courses;
	private JPanel p1;
	private JLabel l1,names,score,teacher;
	private JTextField t1,t2,t3;
	private Choice c2;
	
	Teacher(){
		
		
		p1=new JPanel();
		
		teacher=new JLabel("Enter your name: ");
		teacher.setBounds(0, 60, 150, 25);
		t3=new JTextField(" ",20);
		t3.setBounds(160, 60, 165, 25);
		p1.add(t3);
		p1.add(teacher);
		
		String[] str= {"Choose course","Software Enginnering","Java","Professional Chinese","Artificial Intelligence","Scientific Writing"};
		l1=new JLabel("Courses ");
		l1.setBounds(0, 20, 150, 25);
		courses=new JComboBox(str);
		courses.setBounds(160, 20, 165, 25);
		p1.add(courses);
		p1.add(l1);
		
		
		names=new JLabel("Enter Student Id: ");
		names.setBounds(0, 100, 150, 25);
		p1.add(names);
		
		c2=new Choice();
		try {
			conn c=new conn();
			String str1="select * from student";
			ResultSet rs=c.s.executeQuery(str1);
			while(rs.next()) {
				c2.add(rs.getString("id"));//put nbr of rooms in mysql
			}
		}catch(Exception e1){}
		c2.setBounds(160, 100, 165, 25);
		p1.add(c2);
		
		
				
		score=new JLabel("Enter Scores: ");
		score.setBounds(0, 150, 150, 25);
		t2=new JTextField(" ",20);
		t2.setBounds(160, 150, 165, 25);
		p1.add(score);
		p1.add(t2);
		btn=new JButton("Add");
		btn.setBounds(20,200,100,20);
		btn.addActionListener(this);
		p1.add(btn);
		
		b2=new JButton("check all students");
		b2.setBounds(160,200,150,20);
		b2.addActionListener(this);
		p1.add(b2);
		
		p1.setLayout(null);
		add(p1);
		setTitle("Teacher Platform");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

public static void main(String[]args) {
	new Teacher();
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			String Courses=(String) courses.getSelectedItem();
			String Teacher=t3.getText();
			String Student_id = c2.getSelectedItem();
			String Scores=t2.getText();
			
			
			conn c=new conn();
			String str="insert into information values('"+Courses+"','"+Teacher+"','"+Student_id+"','"+Scores+"')";
			try {
				
				c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Student Score Added");
			} catch (SQLException e1) {
				System.out.println(e1);
				
			}
		
			this.setVisible(true);
		}else if(e.getSource()==b2) {
			new Course().setVisible(true);
		}
	}


}
