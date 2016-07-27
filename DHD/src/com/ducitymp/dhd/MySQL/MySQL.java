package com.ducitymp.dhd.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;

public class MySQL {
	
	private String user = "root";
	private String pass = "usbw";
	private String host = "localhost";
	private String db = "dhd";
	private String poort = "3307";
	private Connection connection;

	public MySQL() {
		this.connect();
	}

	public void close() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public void connect() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + poort + "/" + db + "?autoReconnect=true", user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			Bukkit.broadcastMessage("§c§lKAN DATABASE NIET VINDEN!!!");
		}
	}

	public void Update(String qry) {
		try {
			Statement stmt = this.connection.createStatement();
			stmt.executeUpdate(qry);
			stmt.close();
		} catch (Exception ex) {
			this.connect();
			System.err.println(ex);
		}
	}

	public ResultSet Query(String qry) {
		ResultSet rs = null;
		try {
			Statement stmt = this.connection.createStatement();
			rs = stmt.executeQuery(qry);
		} catch (Exception ex) {
			this.connect();
			System.err.println(ex);
		}
		return rs;
	}
}