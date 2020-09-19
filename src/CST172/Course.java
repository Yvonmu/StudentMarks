package CST172;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Course extends JFrame implements ActionListener {
	private JButton btn;
	private JLabel l;
	private JPanel p;
	private JTable t1;
	Course() {
		p=new JPanel();
		p.setBounds(0,25,400,400);
		
		
		l=new JLabel("All Student Info");
		l.setBounds(90,350,150,20);
		l.setForeground(Color.RED);
		p.add(l);
		btn=new JButton ("Check");
		btn.setBounds(190,350,100,20);
		btn.addActionListener(this);
		p.add(btn);
		p.setLayout(null);
		add(p);
		
		t1=new JTable();
		t1.setBounds(0,40,500,500);
		add(t1);
		
		setResizable(false);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==btn) {
				conn c=new conn();
				try {
					String str="select*from information";
					ResultSet rs=c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				   
				}catch(Exception e1) {
					System.out.println(e1);
					
				}
				
			}
			
		

		
	}

}
