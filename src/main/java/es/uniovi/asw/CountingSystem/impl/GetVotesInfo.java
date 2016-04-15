package es.uniovi.asw.CountingSystem.impl;

import java.util.List;

import es.uniovi.asw.CountingSystem.IGetVotesInfo;
import es.uniovi.asw.CountingSystem.impl.classes.VotesInfo;
import es.uniovi.asw.dbManagement.model.VotoData;

public class GetVotesInfo implements IGetVotesInfo {

	@Override
	public int getVotosPorComunidad(String comunidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVotosPorOpcion(String opcion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VotoData> getVotosTotales() {
		return new VotesInfo().getVotosTotales();
	}

	@Override
	public int getVotosPorTipo(String tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVotosPorOpcionYTipo(String opcion, String tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public  Integer getParticipacion(String lugar) {
		return new VotesInfo().getParticipacion(lugar);
	}
	
}
