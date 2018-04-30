package com;

import com.awt.LoginFrame;
import com.awt.WelcomeScreen;
import com.misc.Misc;
import com.net.MySQL;
import com.table.Table;

public class Launcher {
	
	public static void main(String[] args) {
		MySQL sql = new MySQL();
		Table table = new Table();
		table.createTable();
	}
	
}
