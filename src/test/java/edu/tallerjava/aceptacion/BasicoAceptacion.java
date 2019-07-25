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
}
