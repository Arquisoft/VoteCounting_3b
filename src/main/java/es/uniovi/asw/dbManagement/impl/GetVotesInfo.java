package es.uniovi.asw.dbManagement.impl;

import java.util.Map;

import es.uniovi.asw.dbManagement.IGetVotes;
import es.uniovi.asw.dbManagement.impl.classes.VotosElectronicos;
import es.uniovi.asw.dbManagement.impl.classes.VotosManuales;

public class GetVotesInfo implements IGetVotes{

	@Override
	public Map<String, Integer> getVotosElectronicos() {
		return new VotosElectronicos().getVotos();
	}

	@Override
	public Map<String, Integer> getVotosPorColegio(String colegio) {
		return new VotosManuales().getVotosColegio(colegio);
	}

	@Override
	public Map<String, Integer> getVotosPorComunidad(String comunidad) {
		return null;
	}

}
