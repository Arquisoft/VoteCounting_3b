package es.uniovi.asw.dbManagement.impl;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.dbManagement.IGetCensus;
import es.uniovi.asw.dbManagement.impl.classes.Censo;
import es.uniovi.asw.dbManagement.impl.classes.Colegios;
import es.uniovi.asw.dbManagement.impl.classes.Personas;
import es.uniovi.asw.dbManagement.model.ColegioData;
import es.uniovi.asw.dbManagement.model.PersonaData;

public class GetCensus implements IGetCensus{


	@Override
	public Map<Integer, Integer> getCensoPorColegio() {
		return new Censo().getCensoPorColegio();
	}

	@Override
	public Integer getTotalCenso() {
		return new Censo().total();
	}

	@Override
	public Map<String, Integer> getCensoPorComunidad() {
		return new Censo().getCensoPorComunidad();
	}

	@Override
	public List<ColegioData> getColegios() {
		return new Colegios().getColegios();
	}

	@Override
	public List<PersonaData> getPersonas() {
		// TODO Auto-generated method stub
		return new Personas().getPersonas();
	}
	
	

}
