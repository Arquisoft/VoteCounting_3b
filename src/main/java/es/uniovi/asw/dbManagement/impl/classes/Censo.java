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

	public Map<Integer, Integer> getCensoPorColegio() {
		Connection c = null;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();

		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT CODCOLEGIOELECTORAL FROM CENSOS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (m.containsKey(rs.getInt("CODCOLEGIOELECTORAL")))
					m.replace(rs.getInt("CODCOLEGIOELECTORAL"), m.get(rs.getInt("CODCOLEGIOELECTORAL")),
							m.get(rs.getInt("CODCOLEGIOELECTORAL") + 1));
				else
					m.put(rs.getInt("CODCOLEGIOELECTORAL"), 1);
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

}
