package es.uniovi.asw.dbManagement.impl;

import java.util.List;

import es.uniovi.asw.dbManagement.Colegio;
import es.uniovi.asw.dbManagement.IGetVotes;
import es.uniovi.asw.dbManagement.impl.classes.Opciones;
import es.uniovi.asw.dbManagement.impl.classes.Votantes;
import es.uniovi.asw.dbManagement.impl.classes.Votos;
import es.uniovi.asw.dbManagement.impl.classes.VotosElectronicos;
import es.uniovi.asw.dbManagement.impl.classes.VotosManuales;
import es.uniovi.asw.dbManagement.model.OpcionData;
import es.uniovi.asw.dbManagement.model.VotanteData;
import es.uniovi.asw.dbManagement.model.VotoData;

public class GetVotes implements IGetVotes{

	@Override
	public List<Colegio> getVotosElectronicos() {
		return new VotosElectronicos().getVotos();
	}

	@Override
	public List<Colegio> getVotosManuales(Integer colegio) {
		return new VotosManuales().getVotosColegio(colegio);
	}

	@Override
	public List<Colegio> getVotosPorComunidad(String comunidad) {
		return null;
	}

	@Override
	public int getVotosTotalesElectronicos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OpcionData getOpciones() {
		return new Opciones().getOpciones();
	}

	@Override
	public List<VotoData> getVotos() {
		return new Votos().getVotos();
	}

	@Override
	public List<VotanteData> getVotantesPorColegio(String codColegioElectoral) {
		// TODO Auto-generated method stub
		return new Votantes().findByColegio(codColegioElectoral);
	}


}
