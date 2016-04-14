package es.uniovi.asw.CountingSystem.charts;

public interface ChartModel {

	public void set(String opcion, int valor);
    public void setTitle(String titulo);
    public void setLegendPosition(String posicion);
    public void setFill(boolean fill);
    public void setShowDataLabels(boolean dataLabels);
    public void setDiameter(int diameter);
    
}
