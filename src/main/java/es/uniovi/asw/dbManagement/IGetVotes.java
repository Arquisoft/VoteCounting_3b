package es.uniovi.asw.dbManagement;

import java.util.Map;

public interface IGetVotes {
	
	public Map<String, Integer> getVotosElectronicos();
	
	public Map<String,Integer> getVotosPorColegio(String colegio);
	
	public Map<String,Integer> getVotosPorComunidad(String comunidad);

}
