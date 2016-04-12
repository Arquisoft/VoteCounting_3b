package es.uniovi.asw.controller;

import java.util.List;

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
    return new ModelAndView("landing");
  }

private void mostrarColegios() {
	List<String> colegios = Factories.persistence.census().getColegios();
	for(String s:colegios){
		System.out.println(s);
	}
	if(colegios.isEmpty())
		System.out.println("NO hay coles...");
	
}
  
}