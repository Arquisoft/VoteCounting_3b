package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.dbManagement.Jdbc;


/***
 * 
 * @author Damian
 * Clase que devuelve un mapa con el código del colegio electoral y el número de electores
 * Utilizada para calcular la participación
 * 
 */
public class CensoPorColegios {

	public Map<String, Integer> getCenso() {
		Connection c = null;
		Map<String,Integer> m = new HashMap<String,Integer>();

		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT CODCOLEGIOELECTORAL FROM CENSOS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(m.containsKey(rs.getString(0)))
					m.replace(rs.getString(0), m.get(rs.getString(0)), m.get(rs.getString(0)+1));
				else
					m.put(rs.getString(0), 0);
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las mesas");
			e.printStackTrace();
		}
		return m;
	}
	

}
