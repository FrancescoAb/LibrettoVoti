package it.polito.tdp.librettovoti.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=#I100passi";
		
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println("ERRORE di connessione al database");
			e.printStackTrace();
			return null;
		}
	}

}
