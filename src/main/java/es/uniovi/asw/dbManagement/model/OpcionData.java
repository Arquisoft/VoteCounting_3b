package es.uniovi.asw.dbManagement.model;

import java.util.List;

public class OpcionData {
	
	List<String> opciones;

	public OpcionData(List<String> opciones) {
		super();
		this.opciones = opciones;
	}

	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

}
