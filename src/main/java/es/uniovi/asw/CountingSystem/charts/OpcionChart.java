package es.uniovi.asw.CountingSystem.charts;

public class OpcionChart {

	private String opcion;
	private int valor;

	public OpcionChart(String opcion, int valor) {
		this.setOpcion(opcion);
		this.setValor(valor);
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
