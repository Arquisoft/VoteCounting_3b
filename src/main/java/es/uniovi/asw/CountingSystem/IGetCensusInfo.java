package es.uniovi.asw.CountingSystem;

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

}
