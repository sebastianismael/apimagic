package edu.tallerjava.aceptacion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriesAcceptanceTest {

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
    public void findAll() {
        final List results = this.restTemplate.getForObject(url + "/categories", List.class);
        assertThat(results).hasSize(2);
    }

}
