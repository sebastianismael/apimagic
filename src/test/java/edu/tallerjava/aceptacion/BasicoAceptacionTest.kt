package edu.tallerjava.aceptacion

import edu.tallerjava.delivery.UsuarioDto
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicoAceptacionTest {

    @LocalServerPort
    private val port = 0
    private lateinit var url: String

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Before
    fun init() {
        url = "http://localhost:$port"
    }

    @Test
    fun smoke() {
        val json = restTemplate.getForObject("$url/isAlive", String::class.java)
        Assertions.assertThat(json).isEqualTo("=)")
    }

    @Test
    fun saludar() {
        val nombre = "juan"
        val json = restTemplate.getForObject("$url/saludar/$nombre", String::class.java)
        Assertions.assertThat(json).isEqualTo("{\"nombre\":\"$nombre\",\"saludo\":\"Hola $nombre\"}")
    }

    @Test
    @Throws(Exception::class)
    fun crear() {
        val usuario = UsuarioDto("Ana")
        val json = restTemplate.postForObject("$url/crear", usuario, String::class.java)
        Assertions.assertThat(json).isEqualTo("=)")
    }
}