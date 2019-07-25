package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicoAceptacionTest {

    @LocalServerPort
    private int port;
    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void init(){
        url = "http://localhost:" + port;
    }

    @Test
    public void smoke() {
        final String json = this.restTemplate.getForObject(url + "/isAlive", String.class);
        assertThat(json).isEqualTo("=)");
    }

    @Test
    public void saludar() {
        String nombre = "juan";
        String json = this.restTemplate.getForObject(url + "/saludar/" + nombre, String.class);
        assertThat(json).isEqualTo("{\"nombre\":\"" + nombre + "\",\"saludo\":\"Hola " + nombre + "\"}");
    }

    @Test
    public void crear() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ana");
        String json = this.restTemplate.postForObject(url + "/crear", usuario, String.class);
        assertThat(json).isEqualTo("=)");
    }

}
