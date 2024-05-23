package edu.tallerjava.delivery

import edu.tallerjava.domain.ApiService
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class BasicController(@Autowired private val apiService: ApiService) {

    @GetMapping(path = ["/saludar/{nombre}"])
    fun hi(@PathVariable("nombre") name: String): Hi {
        logger.info("saludando a $name")
        return Hi(name, "Hola $name")
    }

    @PostMapping(path = ["/crear"], consumes = ["application/json"])
    fun create(@RequestBody user: UserDto): String {
        logger.info("creando a " + user.name)
        apiService.create(user.name)
        return "=)"
    }

    @GetMapping(path = ["/isAlive"])
    fun create() = "=)"

    companion object {
        private val logger = getLogger(BasicController::class.java)
    }
}