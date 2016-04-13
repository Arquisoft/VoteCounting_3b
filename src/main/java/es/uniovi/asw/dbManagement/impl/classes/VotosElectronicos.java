package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.dbManagement.Colegio;
import es.uniovi.asw.dbManagement.Jdbc;

public class VotosElectronicos {

	public List<Colegio> getVotos() {
		List<Colegio> colegios = new ArrayList<Colegio>();
		Connection c = null;
		Colegio colegio = null;
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM TABLE VOTOS WHERE TIPO = 'ELECTRONICO'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				colegio = new Colegio(rs.getInt("CODCOLEGIOELECTORAL"), rs.getInt("VOTOS"), rs.getString("COMUNIDAD"), rs.getString("OPCION"),rs.getString("TIPO"));
				if(!colegios.contains(colegio))
					colegios.add(colegio);
			}
			/*while (rs.next()) {
				if(electronicos.containsKey(rs.getInt("CODCOLEGIOELECTORAL")))
					electronicos.replace(rs.getInt("CODCOLEGIOELECTORAL"), electronicos.get(rs.getInt("CODCOLEGIOELECTORAL")), electronicos.get(rs.getInt("CODCOLEGIOELECTORAL")+1));
				else
					electronicos.put(rs.getInt("CODCOLEGIOELECTORAL"), 1);
			}*/
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos del colegio");
			e.printStackTrace();
		}
		return colegios;
	}

}
