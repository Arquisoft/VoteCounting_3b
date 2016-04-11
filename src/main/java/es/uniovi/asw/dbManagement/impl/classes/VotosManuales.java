package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.dbManagement.Jdbc;

public class VotosManuales {

	public Map<String, Integer> getVotosColegio(String colegio) {
			Connection c = null;
			Map<String,Integer> m = new HashMap<String,Integer>();

			try {
				c = Jdbc.getConnection();
				PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM TABLE VOTOS WHERE CODCOLEGIOELECTORAL = ?");
				ps.setString(1, colegio);
				ResultSet rs = ps.executeQuery();
				m.put(colegio, Integer.parseInt(rs.getString(0)));
				c.close();

			} catch (Throwable e) {
				System.out.println("Error al leer los datos del colegio");
				e.printStackTrace();
			}
			return m;

	}

}
