package edu.tallerjava.aceptacion;

import org.junit.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.*;

public class BasicoAceptacion extends TestDeAceptacion{

    @Test
    public void smoke() throws Exception {
        final HttpURLConnection connection = invocarAPI("/isAlive", "GET");
        assertThat(connection.getResponseCode()).isEqualTo(200);
    }

    @Test
    public void saludar() throws Exception {
        String nombre = "juan";
        final HttpURLConnection connection = invocarAPI("/saludar/" + nombre, "GET");
        String json = obtenerRespuesta(connection);
        assertThat(json).isEqualTo("{\"nombre\":\"" + nombre + "\",\"saludo\":\"Hola " + nombre + "\"}");
    }

    @Test
    public void crear() throws Exception {
        final HttpURLConnection connection = invocarAPI("/crear", "POST", "{\"nombre\":\"pedro\"}");
        String json = obtenerRespuesta(connection);
        assertThat(json).isEqualTo("=)");
    }

}
