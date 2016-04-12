package es.uniovi.asw.dbManagement;

import java.util.List;
import java.util.Map;

public interface IGetCensus {
	
	/***
	 * Recuento de electores por colegio
	 * @return mapa con colegios y número de electores
	 */
	public Map<Integer,Integer> getCensoPorColegio();
	
	/***
	 * Lista de colegios. Util para llevar registro de colegios cerrados
	 */
	public List<Integer> getColegios();

	public Integer getTotalCenso();

}
