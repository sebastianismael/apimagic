package edu.tallerjava.delivery

import edu.tallerjava.domain.ApiService
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ControladorBasico(@Autowired private val apiService: ApiService) {
    private val logger = getLogger(ControladorBasico::class.java)

    @GetMapping(path = ["/saludar/{nombre}"])
    fun saludar(@PathVariable("nombre") nombre: String) = Saludo(nombre, "Hola $nombre")

    @PostMapping(path = ["/crear"], consumes = ["application/json"])
    fun crear(@RequestBody usuario: UsuarioDto): String {
        logger.info("creando a " + usuario.nombre)
        apiService.crear(usuario.nombre)
        return "=)"
    }

    @GetMapping(path = ["/isAlive"])
    fun crear(): String = "=)"
}