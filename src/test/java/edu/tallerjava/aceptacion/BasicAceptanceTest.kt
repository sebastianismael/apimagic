package edu.tallerjava.aceptacion

import edu.tallerjava.delivery.UserDto
import org.amshove.kluent.`should be equal to`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class BasicAceptanceTest {

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
        json `should be equal to` "=)"
    }

    @Test
    fun hi() {
        val name = "juan"
        val json = restTemplate.getForObject("$url/saludar/$name", String::class.java)
        json `should be equal to` "{\"name\":\"$name\",\"hi\":\"Hola $name\"}"
    }

    @Test
    fun crear() {
        val user = UserDto("Ana")
        val json = restTemplate.postForObject("$url/crear", user, String::class.java)
        json `should be equal to` "=)"
    }

}