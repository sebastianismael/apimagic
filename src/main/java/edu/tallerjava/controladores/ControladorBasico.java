package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Usuario;
import edu.tallerjava.servicios.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorBasico {

    private static Logger logger = LoggerFactory.getLogger(ControladorBasico.class);
    @Autowired
    private ApiService apiService;

    @GetMapping(path = "/saludar/{nombre}")
    public Saludo saludar(@PathVariable("nombre") String nombre){
        logger.info("saludando a " + nombre);
        return apiService.saludar(nombre);
    }

    @PostMapping(path = "/crear", consumes = "application/json")
    public String crear(@RequestBody Usuario usuario){
        logger.info("creando a " + usuario.getNombre());
        apiService.crear(usuario.getNombre());
        return "=)";
    }

    @GetMapping(path = "/isAlive")
    public String crear(){
        return "=)";
    }
}
