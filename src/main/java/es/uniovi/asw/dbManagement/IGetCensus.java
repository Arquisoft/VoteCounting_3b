package es.uniovi.asw.dbManagement;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.dbManagement.model.ColegioData;
import es.uniovi.asw.dbManagement.model.PersonaData;

public interface IGetCensus {
	
	/***
	 * Recuento de electores por colegio
	 * @return mapa con colegios y número de electores
	 */
	public Map<String,Integer> getCensoPorColegio();

	public Integer getTotalCenso();

	/***
	 * Calcula el censo por comunidad
	 * @return Mapa con las comunidades y el número de votantes
	 */
	public Map<String, Integer> getCensoPorComunidad();
	
	public List<PersonaData> getPersonas();
	
	public List<ColegioData> getColegios();

}
