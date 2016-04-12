package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.dbManagement.Jdbc;

public class VotosManuales {

	public Map<Integer, Integer> getVotosColegio(Integer colegio) {
			Connection c = null;
			Map<Integer,Integer> m = new HashMap<Integer,Integer>();

			try {
				c = Jdbc.getConnection();
				PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM TABLE VOTOS WHERE CODCOLEGIOELECTORAL = ?");
				ps.setInt(1, colegio);
				ResultSet rs = ps.executeQuery();
				m.put(colegio,rs.getInt(1));
				c.close();

			} catch (Throwable e) {
				System.out.println("Error al leer los datos del colegio");
				e.printStackTrace();
			}
			return m;

	}

}
