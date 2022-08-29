package edu.tallerjava.controladores

import edu.tallerjava.servicios.ApiService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ControladorBasico(@Autowired private val apiService: ApiService) {

    @GetMapping(path = ["/saludar/{nombre}"])
    fun saludar(@PathVariable("nombre") nombre: String): Saludo {
        logger.info("saludando a $nombre")
        return Saludo(nombre, "Hola $nombre")
    }

    @PostMapping(path = ["/crear"], consumes = ["application/json"])
    fun crear(@RequestBody usuario: UsuarioDto): String {
        logger.info("creando a " + usuario.nombre)
        apiService.crear(usuario.nombre)
        return "=)"
    }

    @GetMapping(path = ["/isAlive"])
    fun crear(): String {
        return "=)"
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ControladorBasico::class.java)
    }
}