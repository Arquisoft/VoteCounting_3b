package es.uniovi.asw.CountingSystem;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.dbManagement.model.ColegioData;

/***
 * Interfaz para obtener datos sobre el número de votantes, por colegio, comunidad
 * o totales
 * @author Damian
 *
 */
public interface IGetCensusInfo {
	
	public int getVotantesPorColegio(String colegio);
	
	public int getVotantesTotales();
	
	public int getVotantesPorComunidad(String comunidad);

	public Map<String, Integer> getCensoAndColegio();

	public List<ColegioData> getColegios();

	public Integer getVotantesPorCiudad(String ciudad);

}
