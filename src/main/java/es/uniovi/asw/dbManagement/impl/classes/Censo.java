package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.dbManagement.Jdbc;

/***
 * 
 * @author Damian Clase que devuelve un mapa con el código del colegio electoral
 *         y el número de electores Utilizada para calcular la participación
 * 
 */
public class Censo {

	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Map<String, Integer> getCensoPorColegio() {
		Map<String, Integer> m = new HashMap<String, Integer>();

		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement("SELECT CODCOLEGIOELECTORAL FROM CENSOS");
			rs = ps.executeQuery();
			while (rs.next()) {
				String key = rs.getString(1);
				if (m.containsKey(key))
					m.replace(key, m.get(key), m.get(key) + 1);
				else
					m.put(rs.getString("CODCOLEGIOELECTORAL"), 1);
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las mesas");
			e.printStackTrace();
		}
		return m;
	}

	public Integer total() {
		Connection c = null;
		Integer total = 0;

		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM CENSOS");
			ResultSet rs = ps.executeQuery();
			total = rs.getInt(1);
			c.close();
		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las mesas");
			e.printStackTrace();
		}
		return total;
	}

	public Map<String, Integer> getCensoPorComunidad() {
		Connection c = null;
		Map<String, Integer> comunidades = new HashMap<String, Integer>();
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM CENSOS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key = rs.getString(rs.getString("COMUNIDAD"));
				if (comunidades.containsKey(key))
					comunidades.replace(key, comunidades.get(key), comunidades.get(key) + 1);
				else
					comunidades.put(key, 1);
			}
			c.close();
		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las mesas");
			e.printStackTrace();
		}
		return comunidades;
	}

}
