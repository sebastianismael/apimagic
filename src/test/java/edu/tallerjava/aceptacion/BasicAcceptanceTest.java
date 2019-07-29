package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Category;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicAcceptanceTest extends AcceptanceTest{

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
