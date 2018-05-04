package com.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.misc.Misc;

public class MySQL {

	private Connection connection;
	private Statement statement;

	public MySQL() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poker", "root", "");
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String username, String password) {

		return false;
	}

	public boolean register(String username, String password, long key) {
		ResultSet rs = selectAll("users", "name", username);
		try {
			while(rs.next()) {
				if(rs.getString("name") != null) {
					return false;
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		insertUser(username, Misc.hashString(password, key), key);
		return true;

	}

	public boolean insertUser(String username, String password, long key) {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Key: " + key);
		String sql = "INSERT INTO users (name, password, passKey) VALUES ('" + username + "', '" + password + "', '"
				+ key + "')";
		try {
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public ResultSet selectAll(String table, String element, String index) {
		String sql = "SELECT * FROM " + table + " WHERE  " + element + " = '" + index + "'";
		try {
			statement.execute(sql);
			return statement.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
