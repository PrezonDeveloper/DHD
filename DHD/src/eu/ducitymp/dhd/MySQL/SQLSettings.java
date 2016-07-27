package eu.ducitymp.dhd.MySQL;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

public class SQLSettings {
	
	private MySQL mysql;

	public SQLSettings() {
		this.mysql = new MySQL();
		this.mysql.Update(
		"CREATE TABLE IF NOT EXISTS PlayerData(username varchar(100) PRIMARY KEY, PUNTEN int NOT NULL, PARTICLE int NOT NULL, PLAYERS int NOT NULL)");
}

	public void createAccount(Player p) {
		boolean PlayerDataExist = false;
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM PlayerData WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
				PlayerDataExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!PlayerDataExist) {
			this.mysql
					.Update("INSERT INTO PlayerData(username,PUNTEN,PARTICLE,PLAYERS) values ('"
							+ p.getName() + "','" + 0 + "','" + 0 + "','" + 0 + "')");
		}
	}
	
	public int getPUNTEN(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT PUNTEN FROM PlayerData WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public void setPUNTEN(Player p, int amount) {
		this.mysql.Update("UPDATE PlayerData SET PUNTEN='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public int getPLAYERS(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT PLAYERS FROM PlayerData WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public void setPLAYERS(Player p, int amount) {
		this.mysql.Update("UPDATE PlayerData SET PLAYERS='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public int getPARTICLE(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT PARTICLE FROM PlayerData WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public void setPARTICLE(Player p, int amount) {
		this.mysql.Update("UPDATE PlayerData SET PARTICLE='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
}