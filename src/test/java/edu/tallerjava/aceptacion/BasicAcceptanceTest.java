package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Category;
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
public class BasicAcceptanceTest {

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
    public void hi() {
        String nombre = "juan";
        String json = this.restTemplate.getForObject(url + "/hi/" + nombre, String.class);
        assertThat(json).isEqualTo("{\"name\":\"" + nombre + "\",\"hi\":\"Hola " + nombre + "\"}");
    }

    @Test
    public void create() throws Exception {
        Category category = new Category();
        category.setName("Ana");
        String json = this.restTemplate.postForObject(url + "/create", category, String.class);
        assertThat(json).isEqualTo("=)");
    }

}
