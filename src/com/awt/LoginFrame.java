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

public class LoginFrame extends JFrame {
	
	private MySQL sql;
	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JTextField();

	public LoginFrame(String title, MySQL sql) {
		this.setTitle(title);
		this.sql = sql;
	}

	public void initalize(int width, int height) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, width, height);
		JPanel panel = new JPanel();
		usernameField.setPreferredSize(new Dimension(125, 20));
		passwordField.setPreferredSize(new Dimension(125, 20));
		panel.add(usernameField, BorderLayout.NORTH);
		panel.add(passwordField, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		add(createLoginButton(), BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JButton createLoginButton() {
		JButton button = new JButton("Login");
		button.setBounds(0,0, 50, 10);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sql.login(usernameField.getText(), passwordField.getText()))
					new MainFrame(sql).createMainFrame();
				 else 
					new ErrorFrame("Invalid credentials. Please try again!");
			}
		});
		return button;
	}

}
