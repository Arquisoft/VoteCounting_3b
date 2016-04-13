package es.uniovi.asw.CountingSystem;

import java.util.Map;

import es.uniovi.asw.Factories;

public class Recuento {
	
	static int votosTotales =0;
	static int votosElectronicos = 0;
	static int votosManuales = 0;
	static int censadosTotales=0;
	static Map<Integer,Integer> colegios = null;
	static Map<String,Integer> comunidades = null;
	
	public static Map<Integer, Integer> getColegios() {
		if(colegios==null)
			colegios = Factories.persistence.census().getCensoPorColegio();
		return colegios;
	}

	public static int getVotosTotales(){
		if(votosElectronicos==0){
			votosElectronicos += Factories.persistence.votes().getVotosTotalesElectronicos();
			votosTotales+=votosElectronicos;
		}
		return votosTotales;	
	}
	
	public static int getCensadosTotales(){
		if(censadosTotales==0){
			censadosTotales = Factories.persistence.census().getTotalCenso();
		}
		return censadosTotales;
	}

	public static Integer getCensadosComunidad(String comunidad) {
		if(comunidades==null)
			comunidades = Factories.persistence.census().getCensoPorComunidad();
		return comunidades.get(comunidad);
		
	}

}
