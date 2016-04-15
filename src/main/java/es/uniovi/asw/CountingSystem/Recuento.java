package es.uniovi.asw.CountingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.Factories;
import es.uniovi.asw.dbManagement.model.ColegioData;
import es.uniovi.asw.dbManagement.model.VotoData;

public class Recuento {

	static List<VotoData> votosTotales = null;
	static int votosManuales = 0;
	static int censadosTotales = 0;
	static List<ColegioData> colegios = null;
	static Map<String, Integer> comunidades = new HashMap<String, Integer>();
	static Map<String, Integer> censoPorColegio = null;
	static Map<String, Integer> participacion = new HashMap<String, Integer>();
	static Map<String, Integer> ciudades = new HashMap<String, Integer>();
	static Map<String, Map<String, Integer>> votosPorCiudad = new HashMap<String, Map<String, Integer>>();
	static Map<String, Map<String, Integer>> votosPorComunidad = new HashMap<String, Map<String, Integer>>();

	public static List<ColegioData> getColegios() {
		if (colegios == null)
			colegios = Factories.services.CensusInfo().getColegios();
		return colegios;
	}

	public static List<VotoData> getVotosTotales() {
		if (votosTotales == null) {
			votosTotales = new ArrayList<VotoData>();
			votosTotales = Factories.services.VotesInfo().getVotosTotales();

		}
		return votosTotales;
	}

	public static int getCensadosTotales() {
		if (censadosTotales == 0) {
			censadosTotales = Factories.persistence.census().getTotalCenso();
		}
		return censadosTotales;
	}

	public static Integer getCensadosComunidad(String comunidad) {
		if (!comunidades.containsKey(comunidad)) {
			int vot = Factories.services.CensusInfo().getVotantesPorComunidad(comunidad);
			comunidades.put(comunidad, vot);
		}
		return comunidades.get(comunidad);

	}

	public static Integer getCensadosCiudad(String ciudad) {
		Integer vot;
		if (!ciudades.containsKey(ciudad)) {
			vot = Factories.services.CensusInfo().getVotantesPorCiudad(ciudad);
			ciudades.put(ciudad, vot);
		}
		return ciudades.get(ciudad);
	}

	public static Map<String, Integer> getCensoAndColegio() {
		if (censoPorColegio == null)
			censoPorColegio = Factories.services.CensusInfo().getCensoAndColegio();
		return censoPorColegio;
	}

	public static Object getParticipacion(String lugar) {
		if (participacion.get(lugar) == null) {
			participacion.put(lugar, Factories.services.VotesInfo().getParticipacion(lugar));
			Integer votantesPotenciales = comunidades.get(lugar);
			if (votantesPotenciales == null) {
				votantesPotenciales = ciudades.get(lugar);
			}
		}
		return participacion.get(lugar);
	}

	public static Map<String, Integer> getVotosPorCiudad(String lugar) {
		Map<String, Integer> cantidad = new HashMap<String, Integer>();
		List<ColegioData> colegios;
		if (!votosPorCiudad.containsKey(lugar)) {
			List<VotoData> votos = getVotosTotales();
			colegios = getColegios();
			colegios.removeIf(colegio -> !colegio.getCiudad().equals(lugar));
			System.out.println(votos);
			List<VotoData> aux = new ArrayList<VotoData>();
			for(ColegioData colegio:colegios)
				votos.forEach(v->{
					if(v.getCodColegioElectoral().equals(colegio.getCodColegioElectoral()))
						aux.add(v);
					});
			for (VotoData voto : aux) {
				System.out.println(voto);
				Integer votosSi;
				Integer votosNo;
				Integer votosBlanco;
				if (voto.getOpcion().compareTo(0L) == 0) {
					votosSi = voto.getTotalVotos();
					if (cantidad.containsKey("SI"))
						cantidad.replace("SI", cantidad.get("SI"), cantidad.get("SI") + votosSi);
					else
						cantidad.put("SI", votosSi);
				} else if (voto.getOpcion().compareTo(1L) == 0) {
					votosNo = voto.getTotalVotos();
					if (cantidad.containsKey("NO"))
						cantidad.replace("NO", cantidad.get("NO"), cantidad.get("NO") + votosNo);
					else
						cantidad.put("NO", votosNo);
				} else {
					votosBlanco = voto.getTotalVotos();
					if (cantidad.containsKey("BLANCO"))
						cantidad.replace("BLANCO", cantidad.get("BLANCO"), cantidad.get("BLANCO") + votosBlanco);
					else
						cantidad.put("BLANCO", votosBlanco);

				}

			}
			votosPorCiudad.put(lugar, cantidad);
			System.out.println(cantidad);

		}

		return votosPorCiudad.get(lugar);

	}

	public static Map<String, Integer> getVotosPorComunidad(String lugar) {
		Map<String, Integer> cantidad = new HashMap<String, Integer>();
		if (!votosPorComunidad.containsKey(lugar)) {
			List<VotoData> votos = getVotosTotales();
			colegios = getColegios();
			System.out.println("Colegios antes:");
			System.out.println(colegios);
			colegios.removeIf(colegio -> !colegio.getComunidadAutonoma().equals(lugar));
			System.out.println("Colegios despues:");
			System.out.println(colegios);
			for (ColegioData colegio : colegios)
				votos.removeIf(voto -> !voto.getCodColegioElectoral().equals(colegio.getCodColegioElectoral()));
			System.out.println(votos);
			for (VotoData voto : votos) {
				Integer votosSi;
				Integer votosNo;
				Integer votosBlanco;
				if (voto.getOpcion().compareTo(0L) == 0) {
					votosSi = voto.getTotalVotos();
					if (cantidad.containsKey("SI"))
						cantidad.replace("SI", cantidad.get("SI"), cantidad.get("SI") + votosSi);
					else
						cantidad.put("SI", votosSi);
				} else if (voto.getOpcion().compareTo(1L) == 0) {
					votosNo = voto.getTotalVotos();
					if (cantidad.containsKey("NO"))
						cantidad.replace("NO", cantidad.get("NO"), cantidad.get("NO") + votosNo);
					else
						cantidad.put("NO", votosNo);
				} else {
					votosBlanco = voto.getTotalVotos();
					if (cantidad.containsKey("BLANCO"))
						cantidad.replace("BLANCO", cantidad.get("BLANCO"), cantidad.get("BLANCO") + votosBlanco);
					else
						cantidad.put("BLANCO", votosBlanco);

				}

			}
			votosPorComunidad.put(lugar, cantidad);
			System.out.println(cantidad);

		}

		return votosPorComunidad.get(lugar);

	}

}
