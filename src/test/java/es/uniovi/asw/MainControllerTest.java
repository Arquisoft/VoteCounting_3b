package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.CountingSystem.Recuento;
import es.uniovi.asw.dbManagement.model.VotoData;

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

		votos.values().forEach(voto -> {
			votosSi = votos.get("votosSi");
			votosNo = votos.get("votosNo");
			votosBlanco = votos.get("votosBlanco");
		});

	}

}