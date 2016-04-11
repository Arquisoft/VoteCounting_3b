package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.dbManagement.Jdbc;

public class VotosElectronicos {

	public static Map<String, Integer> getVotos() {
		Map<String, Integer> electronicos = new HashMap<String, Integer>();
		Connection c = null;
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT CODCOLEGIOELECTORAL FROM TABLE VOTOS WHERE TIPO = 'ELECTRONICO'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(electronicos.containsKey(rs.getString(0)))
					electronicos.replace(rs.getString(0), electronicos.get(rs.getString(0)), electronicos.get(rs.getString(0)+1));
				else
					electronicos.put(rs.getString(0), 0);
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos del colegio");
			e.printStackTrace();
		}
		return electronicos;
	}

}
