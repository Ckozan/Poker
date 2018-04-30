package com.awt;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ErrorFrame {

	private String error;

	public ErrorFrame(String message) {
		error = message;
		promptError();
	}

	public void promptError() {
		JOptionPane.showMessageDialog(null, error);
	}
}
