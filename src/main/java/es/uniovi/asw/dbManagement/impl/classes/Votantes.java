package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.dbManagement.Jdbc;
import es.uniovi.asw.dbManagement.model.VotanteData;

public class Votantes {

	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<VotanteData> findByColegio(String codColegioElectoral) {
		List<VotanteData> votantes = new ArrayList<VotanteData>();

		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement("SELECT * FROM VOTANTE");
			rs = ps.executeQuery();
			while (rs.next()) {
				votantes.add(new VotanteData(rs.getString("nif"), rs.getString("tipoVoto"), rs.getBoolean("estado"),
						rs.getLong("idVotacion")));
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las mesas");
			e.printStackTrace();
		}
		return votantes;
	}

}
