package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.dbManagement.Jdbc;

public class Colegios {

	public List<String> list() {
		Connection c = null;
		List<String> colegios = new ArrayList<String>();

		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT CODCOLEGIOELECTORAL FROM CENSOS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(!colegios.contains(rs.getShort(0)))
					colegios.add(rs.getString(0));
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las mesas");
			e.printStackTrace();
		}
		return colegios;
	}

}
