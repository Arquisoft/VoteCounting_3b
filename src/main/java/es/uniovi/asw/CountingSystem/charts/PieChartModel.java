package es.uniovi.asw.CountingSystem.charts;

import java.util.HashSet;
import java.util.Set;

public class PieChartModel implements ChartModel {

	Set<OpcionChart> opciones = new HashSet<OpcionChart>();
	private String titulo;
	private String posicion;
	private boolean fill;
	private boolean dataLabels;
	private int diameter;

	public Set<OpcionChart> getOpciones() {
		return opciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getPosicion() {
		return posicion;
	}

	public boolean isFill() {
		return fill;
	}

	public boolean isDataLabels() {
		return dataLabels;
	}

	public int getDiameter() {
		return diameter;
	}

	public void set(String opcion, int valor) {
		opciones.add(new OpcionChart(opcion, valor));
	}

	@Override
	public void setTitle(String titulo) {
		this.titulo = titulo;

	}

	@Override
	public void setLegendPosition(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public void setFill(boolean fill) {
		this.fill = fill;
	}

	@Override
	public void setShowDataLabels(boolean dataLabels) {
		this.dataLabels = dataLabels;
	}

	@Override
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

}
