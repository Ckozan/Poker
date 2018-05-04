package com;

import com.awt.WelcomeScreen;
import com.net.MySQL;

public class Launcher {
	
	public static void main(String[] args) {
		MySQL sql = new MySQL();
		WelcomeScreen welcome = new WelcomeScreen("Welcome!", sql);
		welcome.createFrame();
	}
	
}
