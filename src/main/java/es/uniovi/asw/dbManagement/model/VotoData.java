package es.uniovi.asw.dbManagement.model;

public class VotoData {
	String tipoVoto;
	Long opcion;
	Long totalVotos;
	Long idVotacion;
	Long codColegioElectoral;
	
	public String getTipoVoto() {
		return tipoVoto;
	}
	public void setTipoVoto(String tipoVoto) {
		this.tipoVoto = tipoVoto;
	}
	public Long getOpcion() {
		return opcion;
	}
	public void setOpcion(Long opcion) {
		this.opcion = opcion;
	}
	public Long getTotalVotos() {
		return totalVotos;
	}
	public void setTotalVotos(Long totalVotos) {
		this.totalVotos = totalVotos;
	}
	public Long getIdVotacion() {
		return idVotacion;
	}
	public void setIdVotacion(Long idVotacion) {
		this.idVotacion = idVotacion;
	}
	public Long getCodColegioElectoral() {
		return codColegioElectoral;
	}
	public void setCodColegioElectoral(Long codColegioElectoral) {
		this.codColegioElectoral = codColegioElectoral;
	}
	public VotoData(String tipoVoto, Long opcion, Long totalVotos, Long idVotacion, Long codColegioElectoral) {
		super();
		this.tipoVoto = tipoVoto;
		this.opcion = opcion;
		this.totalVotos = totalVotos;
		this.idVotacion = idVotacion;
		this.codColegioElectoral = codColegioElectoral;
	}
	@Override
	public String toString() {
		return "VotoData [tipoVoto=" + tipoVoto + ", opcion=" + opcion + ", totalVotos=" + totalVotos + ", idVotacion="
				+ idVotacion + ", codColegioElectoral=" + codColegioElectoral + "]";
	}
	
	

}
