package es.uniovi.asw.dbManagement;

public class Colegio {
	
	private String identificador;
	private int numeroVotantes;
	
	public Colegio(String identificador, int numeroVotantes) {
		super();
		this.identificador = identificador;
		this.numeroVotantes = numeroVotantes;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public int getNumeroVotantes() {
		return numeroVotantes;
	}
	public void setNumeroVotantes(int numeroVotantes) {
		this.numeroVotantes = numeroVotantes;
	}

}
