package es.uniovi.asw.CountingSystem;

import java.util.Map;

import es.uniovi.asw.Factories;

public class RecuentoElectronico {
	
	static int votosTotales =0;
	static int censadosTotales=0;
	
	static int getVotosTotales(){
		if(votosTotales==0){
			votosTotales += Factories.persistence.votes().getVotosTotalesElectronicos();
			votosTotales += Factories.persistence.votes().getVotosTotalesManuales();
		}
		return votosTotales;	
	}
	
	static int getCensadosTotales(){
		if(censadosTotales==0){
			censadosTotales = Factories.persistence.census().getTotalCenso();
		}
		return censadosTotales;
	}

}
