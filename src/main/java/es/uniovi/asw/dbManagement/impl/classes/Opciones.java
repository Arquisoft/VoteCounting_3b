package es.uniovi.asw.dbManagement.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.uniovi.asw.dbManagement.Jdbc;
import es.uniovi.asw.dbManagement.model.OpcionData;

public class Opciones {

	Connection c= null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public OpcionData getOpciones() {
		
		OpcionData opciones = new OpcionData(new ArrayList<String>(),null);

		try {
			c = Jdbc.getConnection();
			 ps = c.prepareStatement("SELECT * FROM OPCION");
			 rs = ps.executeQuery();
			while (rs.next()) {
				opciones.getOpciones().add(rs.getString("nombre"));
				opciones.setIdVotacion(rs.getLong("idVotacion"));
			}
			c.close();

		} catch (Throwable e) {
			System.out.println("Error al leer los datos de las opciones");
			e.printStackTrace();
		}
		return opciones;
	}

}
