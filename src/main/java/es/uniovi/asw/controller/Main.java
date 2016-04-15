package es.uniovi.asw.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.Factories;
import es.uniovi.asw.CountingSystem.Recuento;
import es.uniovi.asw.CountingSystem.charts.ChartView;
import es.uniovi.asw.dbManagement.model.ColegioData;
import es.uniovi.asw.dbManagement.model.VotoData;



@Controller
@RestController
public class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  @RequestMapping(value="/")
  public ModelAndView landing(Model model) {
    LOG.info("Landing page access");
    
    mostrarColegios();
    mostrarCensoPorColegios();
    //mostrarVotosTotales();
    //mostrarParticipacion(null);
    mostrarVotosPorComunidad("Oviedo");
    
    return new ModelAndView("index");
  }
  
  private void mostrarVotosPorComunidad(String lugar) {
	Map<String, Integer> v = Recuento.getVotosPorCiudad(lugar);
	Set<String> aux = v.keySet();	
	System.out.println("Votos en " + lugar);
	for(String a:aux)
		System.out.println("Opcion " + a +", votos: "+ v.get(a));
	
	
}

private void mostrarParticipacion(String lugar) {
	Object participacion = Recuento.getParticipacion(lugar);
	
}

@RequestMapping(value="/mostrarEstadisticas")
  public ChartView DevolverGrafico(){
	  return null;
  }
  
  
  
private void mostrarVotosTotales() {
	System.out.println("Votos totales");
	List<VotoData> total = Recuento.getVotosTotales();
	for(VotoData v: total)
		System.out.println(v.toString());
	
}

private void mostrarCensoPorColegios() {
	System.out.println("Censo por colegios");
	Map<String, Integer> censo = Recuento.getCensoAndColegio();
	Set<String> aux = censo.keySet();	
	for(String a:aux)
		System.out.println("Codigo colegio: " +a +", Censo: "+ censo.get(a));
	System.out.println(censo.values().toString());
	
}

private void mostrarColegios() {

	System.out.println("Colegios");
	List<ColegioData> colegios = Recuento.getColegios();
	for(ColegioData s:colegios){
		System.out.println(s.getComunidadAutonoma() + " -> Código colegio: " + s.getCodColegioElectoral());

	}
	if(colegios.isEmpty())
		System.out.println("NO hay coles...");
	
}
  
}