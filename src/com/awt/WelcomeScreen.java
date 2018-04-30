package com.awt;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.net.MySQL;

public class WelcomeScreen extends Frame {

	
	public WelcomeScreen(String title, MySQL sql) {
		super(title, sql);
	}
	
	public void createFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 260, 110);
		JPanel panel = new JPanel();
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame login = new LoginFrame("Login", getSQL());
				login.initalize(200, 125);
				closeFrame();
			}
			
		});
		JButton register = new JButton("Create an account");
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterFrame("Register", getSQL()).loadFrame();
				closeFrame();
			}
			
		});
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		register.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(login, BorderLayout.LINE_START);
		panel.add(register, BorderLayout.LINE_END);
		JPanel panel2 = new JPanel();
		JLabel line1 = new JLabel("Welcome to the Casino!");
		JLabel line2 = new JLabel("Please either login or create an account!");
		panel2.add(line1, BorderLayout.NORTH);
		panel2.add(line2, BorderLayout.CENTER);
		add(panel2, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}
	
	
	public void closeFrame() {
		setVisible(false);
		dispose();
	}
	
	
}
