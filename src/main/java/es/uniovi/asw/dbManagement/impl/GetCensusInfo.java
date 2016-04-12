package es.uniovi.asw.dbManagement.impl;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.dbManagement.IGetCensus;
import es.uniovi.asw.dbManagement.impl.classes.Censo;
import es.uniovi.asw.dbManagement.impl.classes.Colegios;

public class GetCensusInfo implements IGetCensus{


	@Override
	public Map<Integer, Integer> getCensoPorColegio() {
		return new Censo().getCensoPorColegio();
	}

	@Override
	public List<Integer> getColegios() {
		// TODO Auto-generated method stub
		return new Colegios().list();
	}

	@Override
	public Integer getTotalCenso() {
		// TODO Auto-generated method stub
		return new Censo().total();
	}
	
	

}
