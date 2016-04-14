package es.uniovi.asw.CountingSystem.impl.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.Factories;
import es.uniovi.asw.dbManagement.model.ColegioData;
import es.uniovi.asw.dbManagement.model.PersonaData;

public class PersonasCenso {

	Connection c = null;
	PreparedStatement ps;
	ResultSet rs;

	public int findByColegio(String colegio) {
		List<PersonaData> personas = Factories.persistence.census().getPersonas();
		int votantes=0;
		for(PersonaData p:personas)
			if(p.getCodColegioElectoral().equals(colegio))
				votantes++;
		return votantes;
	}

	public int findAll() {
		return Factories.persistence.census().getPersonas().size();
	}

	public int findByComunidad(String comunidad) {
		List<PersonaData> personas = Factories.persistence.census().getPersonas();
		List<ColegioData> colegios = Factories.persistence.census().getColegios();
		List<String> codigos = new ArrayList<String>();
		int contador=0;
		for(ColegioData c:colegios)
			if(c.getComunidadAutonoma().equals(comunidad))
				 codigos.add(c.getCodColegioElectoral());
		for(PersonaData p:personas)
			if(codigos.contains(p.getCodColegioElectoral()))
				contador++;
		return contador;
		
	}

}
