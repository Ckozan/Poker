package com.awt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.net.MySQL;

public class RegisterFrame extends Frame {
	

	public RegisterFrame(String title, MySQL sql) {
		super(title, sql);
	}

	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JTextField();
	
	public void loadFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 250, 125);
		JPanel panel = new JPanel();
		usernameField.setPreferredSize(new Dimension(125, 20));
		passwordField.setPreferredSize(new Dimension(125, 20));
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getSQL().register(usernameField.getText(), passwordField.getText(), System.currentTimeMillis())){
					System.out.println("yeet");
					new ConfirmationFrame("Registration successful", getSQL()).createConfirmationFrame();
					closeFrame();
				}
			}
		});
		panel.add(usernameField, BorderLayout.NORTH);
		panel.add(passwordField, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		add(register, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}