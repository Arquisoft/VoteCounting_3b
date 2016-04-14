package es.uniovi.asw.CountingSystem.impl;

import es.uniovi.asw.CountingSystem.IGetCensusInfo;
import es.uniovi.asw.CountingSystem.impl.classes.PersonasCenso;

public class GetCensusInfo implements IGetCensusInfo {

	@Override
	public int getVotantesPorColegio(String colegio) {
		// TODO Auto-generated method stub
		return new PersonasCenso().findByColegio(colegio);
	}

	@Override
	public int getVotantesTotales() {
		// TODO Auto-generated method stub
		return new PersonasCenso().findAll();
	}

	@Override
	public int getVotantesPorComunidad(String comunidad) {
		// TODO Auto-generated method stub
		return new PersonasCenso().findByComunidad(comunidad);
	}
	

	

}
