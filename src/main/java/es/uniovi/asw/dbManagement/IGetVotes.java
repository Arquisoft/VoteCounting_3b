package es.uniovi.asw.dbManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.model.OpcionData;
import es.uniovi.asw.dbManagement.model.VotanteData;
import es.uniovi.asw.dbManagement.model.VotoData;

public interface IGetVotes {
	
	/***
	 * Recuenta los votos electrónicos. Sólo se debería llamar una vez
	 * @return Listado de colegios 
	 */
	public List<Colegio> getVotosElectronicos();
	
	/***
	 * Recuenta los votos manuales para un colegio determinado. Se debería llamar
	 * cuando se introduzcan en la base de datos los votos de un colegio determinado
	 * @param colegio Código del colegio
	 * @return Lista con dos colegios, uno para los votos si y otra para los votos no
	 */
	public List<Colegio> getVotosManuales(Integer colegio);
	
	public List<Colegio> getVotosPorComunidad(String comunidad);

	public int getVotosTotalesElectronicos();
	
	public OpcionData getOpciones();
	
	public List<VotoData> getVotos();

	public List<VotanteData> getVotantesPorColegio(String codColegioElectoral);

}
