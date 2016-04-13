package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.dbManagement.Colegio;
import es.uniovi.asw.dbManagement.Jdbc;

public class VotosManuales {

	public List<Colegio> getVotosColegio(Integer colegio) {
			Connection c = null;
			List<Colegio> colegios = new ArrayList<Colegio>();

			try {
				c = Jdbc.getConnection();
				PreparedStatement ps = c.prepareStatement("SELECT * FROM TABLE VOTOS WHERE CODCOLEGIOELECTORAL = ? AND OPCION='MANUAL'");
				ps.setInt(1, colegio);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
					colegios.add(new Colegio(colegio, rs.getInt("VOTOS"), rs.getString("COMUNIDAD"), rs.getString("OPCION"),rs.getString("TIPO")));
				c.close();

			} catch (Throwable e) {
				System.out.println("Error al leer los datos del colegio");
				e.printStackTrace();
			}
			return colegios;

	}

}
