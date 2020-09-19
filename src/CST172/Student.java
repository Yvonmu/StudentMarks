package CST172;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;



public class Student extends JFrame implements ActionListener {
	private JPanel p;
	private JLabel l,l1,l2,l3;
	private JTextField first,last,t2;
	private JButton btn,b2;
	Student(){
		p=new JPanel();
		l1=new JLabel("Add New Student");
		l1.setBounds(40,0,100,20);
		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.RED);
		p.add(l1);
		
		l=new JLabel("First Name ");
		l.setBounds(0,40,100,20);
		first=new JTextField();
		first.setBounds(120,40,100,20);
		p.add(l);
		p.add(first);
		
		l2=new JLabel("Last Name ");
		l2.setBounds(0,100,100,20);
		last=new JTextField();
		last.setBounds(120,100,100,20);
		p.add(l2);
		p.add(last);
		
		l3=new JLabel("Student Id ");
		l3.setBounds(0,150,100,20);
		t2=new JTextField();
		t2.setBounds(120,150,100,20);
		p.add(l3);
		p.add(t2);
		
		btn=new JButton("Add");
		btn.setBounds(80,200,70,20);
		btn.addActionListener(this);
		p.add(btn);
		
		p.setLayout(null);
		add(p);
		setResizable(false);
		setVisible(true);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			String firstName=first.getText();
			String lastName=last.getText();
			String id=t2.getText();
			
			
			conn c=new conn();
			String str="insert into student values('"+firstName+"','"+lastName+"','"+id+"')";
			try {
				
				c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Student Added");
			} catch (SQLException e1) {
				System.out.println(e1);
				
			}
		
			this.setVisible(true);
		}
		
	}

}
