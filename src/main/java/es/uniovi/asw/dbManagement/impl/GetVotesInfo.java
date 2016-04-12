package es.uniovi.asw.dbManagement.impl;

import java.util.Map;

import es.uniovi.asw.dbManagement.IGetVotes;
import es.uniovi.asw.dbManagement.impl.classes.VotosElectronicos;
import es.uniovi.asw.dbManagement.impl.classes.VotosManuales;

public class GetVotesInfo implements IGetVotes{

	@Override
	public Map<Integer, Integer> getVotosElectronicos() {
		return VotosElectronicos.getVotos();
	}

	@Override
	public Map<Integer, Integer> getVotosPorColegio(Integer colegio) {
		return new VotosManuales().getVotosColegio(colegio);
	}

	@Override
	public Map<Integer, Integer> getVotosPorComunidad(String comunidad) {
		return null;
	}

}
