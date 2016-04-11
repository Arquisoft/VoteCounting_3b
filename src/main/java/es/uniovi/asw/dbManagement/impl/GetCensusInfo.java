package es.uniovi.asw.dbManagement.impl;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.dbManagement.IGetCensus;
import es.uniovi.asw.dbManagement.impl.classes.CensoPorColegios;
import es.uniovi.asw.dbManagement.impl.classes.Colegios;

public class GetCensusInfo implements IGetCensus{


	@Override
	public Map<String, Integer> getCensoPorColegio() {
		return new CensoPorColegios().getCenso();
	}

	@Override
	public List<String> getColegios() {
		// TODO Auto-generated method stub
		return new Colegios().list();
	}
	
	

}
