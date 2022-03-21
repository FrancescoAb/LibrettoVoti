package it.polito.tdp.librettovoti.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.model.Voto;

public class LibrettoDAO {
	public boolean creaVoto(Voto v) {
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql = "INSERT INTO voti(nome, punti) VALUES (?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, v.getNome());
			st.setInt(2, v.getPunti());
			int res = st.executeUpdate();
			st.close();
			conn.close();
			if (res==1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public List<Voto> readAllVoto() {
		try {
			Connection conn = DBConnect.getConnection();
			String sql = "SELECT * FROM voti";
			
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			
			ResultSet res = st.executeQuery(sql);
			List<Voto> result = new ArrayList<>();
			
			while(res.next()) {
				String nome = res.getString("nome");
				int punti = res.getInt("punti");
				result.add(new Voto(nome, punti));
			}
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		 
	}
	
	//public Voto readVotoByNome(String nome) {}
}
