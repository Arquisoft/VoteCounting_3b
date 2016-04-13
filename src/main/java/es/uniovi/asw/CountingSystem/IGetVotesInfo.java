package es.uniovi.asw.CountingSystem;


/***
 * Interfaz para estadísticas. Añadir métodos en función de las estadísticas
 * que necesitemos
 * @author Damian
 *
 */
public interface IGetVotesInfo {
	
	public int getVotosPorComunidad(String comunidad);
	
	public int getVotosPorOpcion(String opcion);
	
	public int getVotosTotales();
	
	public int getVotosPorTipo(String tipo);
	
	public int getVotosPorOpcionYTipo(String opcion, String tipo);

}
