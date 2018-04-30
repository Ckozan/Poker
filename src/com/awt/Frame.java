package com.awt;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.net.MySQL;

public class Frame extends JFrame {

	private MySQL sql;
	
	public Frame(String title, MySQL sql) {
		setTitle(title);
		this.sql = sql;
	}
	
	public MySQL getSQL() {
		return sql;
	}
	
	
	public void closeFrame() {
		setVisible(false);
		dispose();
	}
}
