package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.dbManagement.Jdbc;

public class VotosElectronicos {

	public static Map<Integer, Integer> getVotos() {
		Map<Integer, Integer> electronicos = new HashMap<Integer, Integer>();
		Connection c = null;
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT CODCOLEGIOELECTORAL FROM TABLE VOTOS WHERE TIPO = 'ELECTRONICO'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(electronicos.containsKey(rs.getInt("CODCOLEGIOELECTORAL")))
					electronicos.replace(rs.getInt("CODCOLEGIOELECTORAL"), electronicos.get(rs.getInt("CODCOLEGIOELECTORAL")), electronicos.get(rs.getInt("CODCOLEGIOELECTORAL")+1));
				else
					electronicos.put(rs.getInt("CODCOLEGIOELECTORAL"), 1);
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos del colegio");
			e.printStackTrace();
		}
		return electronicos;
	}

}
