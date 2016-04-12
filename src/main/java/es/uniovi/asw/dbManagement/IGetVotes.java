package es.uniovi.asw.dbManagement;

import java.util.Map;

public interface IGetVotes {
	
	public Map<Integer, Integer> getVotosElectronicos();
	
	public Map<Integer,Integer> getVotosPorColegio(Integer colegio);
	
	public Map<Integer,Integer> getVotosPorComunidad(String comunidad);

	public int getVotosTotalesElectronicos();

}
