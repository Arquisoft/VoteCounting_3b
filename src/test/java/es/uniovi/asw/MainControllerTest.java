package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.CountingSystem.Recuento;
import es.uniovi.asw.dbManagement.model.ColegioData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {
	Integer votosSi = null;
	Integer votosNo = null;
	Integer votosBlanco = null;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testLanding() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("Bienvenido")));
	}

	@Test
	public void testVotosTotales() throws Exception {
		Map<String, Integer> votos = Recuento.getMapaVotosTotales().get("España");
		assertTrue("El número de votos totales afirmativos es " + votos.get("SI"), votos.get("SI").equals(711));
		assertTrue("El número de votos totales negativos es " + votos.get("NO"), votos.get("NO").equals(333));
		assertTrue("El número de votos totales en blanco es " + votos.get("BLANCO"), votos.get("BLANCO").equals(465));
	}

	@Test
	public void testVotosPorCiudad() {
		List<String> ciudades = Recuento.getCiudades();
		for (String ciudad : ciudades) {
			Map<String, Integer> votos = Recuento.getVotosPorCiudad(ciudad);
			votosSi = votos.get("SI");
			votosNo = votos.get("NO");
			votosBlanco = votos.get("BLANCO");
			if (ciudad.equals("Oviedo"))
				assertTrue(votosSi + " " + votosNo + " " + votosBlanco,
						votosSi.equals(237) && votosNo.equals(111) && votosBlanco.equals(155));
			else if (ciudad.equals("Vigo"))
				assertTrue(votosSi + " " + votosNo + " " + votosBlanco,
						votosSi.equals(237) && votosNo.equals(111) && votosBlanco.equals(155));
			else if (ciudad.equals("Santander"))
				assertTrue(votosSi + " " + votosNo + " " + votosBlanco,
						votosSi.equals(237) && votosNo.equals(111) && votosBlanco.equals(155));
		}
	}

	@Test
	public void testVotosPorComunidad() {
		List<String> comunidades = Recuento.getComunidades();
		comunidades.forEach(comunidad -> {
			Map<String, Integer> votos = Recuento.getVotosPorComunidad(comunidad);
			votosSi = votos.get("SI");
			votosNo = votos.get("NO");
			votosBlanco = votos.get("BLANCO");
			if (comunidad.equals("Asturias"))
				assertTrue(votosSi + " " + votosNo + " " + votosBlanco,
						votosSi.equals(237) && votosNo.equals(111) && votosBlanco.equals(155));
			else if (comunidad.equals("Galicia"))
				assertTrue(votosSi + " " + votosNo + " " + votosBlanco,
						votosSi.equals(237) && votosNo.equals(111) && votosBlanco.equals(155));
			else if (comunidad.equals("Cantabria"))
				assertTrue(votosSi + " " + votosNo + " " + votosBlanco,
						votosSi.equals(237) && votosNo.equals(111) && votosBlanco.equals(155));
		});

	}
	
	@Test
	public void testParticipacionPorLugar(){
		System.out.println(Recuento.getParticipacion("Asturias"));
	}

}