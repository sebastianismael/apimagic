package edu.apimagic.aceptance;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicAcceptanceTest extends AcceptanceTest {

    @Test
    public void smoke() {
        final String json = this.restTemplate.getForObject(this.url + "/isAlive", String.class);
        assertThat(json).isEqualTo("=)");
    }
}
