package es.uniovi.asw.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.Factories;


@Controller
public class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  @RequestMapping("/prueba")
  public ModelAndView landing(Model model) {
    LOG.info("Landing page access");
    mostrarColegios();
    mostrarCensoPorColegios();
    return new ModelAndView("landing");
  }

private void mostrarCensoPorColegios() {
	Map<Integer, Integer> censo = Factories.persistence.census().getCensoPorColegio();
	Set<Integer> aux = censo.keySet();	
	for(Integer a:aux)
		System.out.println(a +" "+ censo.get(a));
	
}

private void mostrarColegios() {
	List<Integer> colegios = Factories.persistence.census().getColegios();
	for(Integer s:colegios){
		System.out.println(s);
	}
	if(colegios.isEmpty())
		System.out.println("NO hay coles...");
	
}
  
}