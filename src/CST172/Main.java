package CST172;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame implements ActionListener {
	private JButton b1,b2;
	private JPanel p;
	Main(){
		p=new JPanel();
		
		b1=new JButton("Add Student");
		b1.setBounds(50,50,200,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("Students Marks");
		b2.setBounds(50,190,200,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		p.add(b2);
		
		p.setLayout(null);
		add(p);
		setBackground(Color.CYAN);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			new Student().setVisible(true);
		}else if(e.getSource()==b2) {
			
			new Teacher().setVisible(true);
		}
		
		
	}

}
