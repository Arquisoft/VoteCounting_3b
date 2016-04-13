package es.uniovi.asw.dbManagement.model;

	
	public class ColegioData{
		String comunidad;
		int codColegioElectoral;
		
		public String getComunidad() {
			return comunidad;
		}

		public void setComunidad(String comunidad) {
			this.comunidad = comunidad;
		}

		public int getCodColegioElectoral() {
			return codColegioElectoral;
		}

		public void setCodColegioElectoral(int codColegioElectoral) {
			this.codColegioElectoral = codColegioElectoral;
		}

		public ColegioData(String comunidad, int codColegioElectoral) {
			super();
			this.comunidad = comunidad;
			this.codColegioElectoral = codColegioElectoral;
		}
	

}
