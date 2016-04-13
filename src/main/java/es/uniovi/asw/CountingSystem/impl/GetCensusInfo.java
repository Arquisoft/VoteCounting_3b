package es.uniovi.asw.CountingSystem.impl;

import es.uniovi.asw.CountingSystem.IGetCensusInfo;
import es.uniovi.asw.CountingSystem.impl.classes.Votantes;

public class GetCensusInfo implements IGetCensusInfo {

	@Override
	public int getVotantesPorColegio(int colegio) {
		// TODO Auto-generated method stub
		return new Votantes().findByColegio(colegio);
	}

	@Override
	public int getVotantesTotales() {
		// TODO Auto-generated method stub
		return new Votantes().findAll();
	}

	@Override
	public int getVotantesPorComunidad(String comunidad) {
		// TODO Auto-generated method stub
		return new Votantes().findByComunidad(comunidad);
	}
	

	

}
