package edu.tallerjava.controladores;

import edu.tallerjava.servicios.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBasico {

    private static Logger logger = LoggerFactory.getLogger(ControladorBasico.class);
    @Autowired
    private ApiService apiService;

    @GetMapping("/saludar/{nombre}")
    public Saludo saludar(@PathVariable("nombre") String nombre){
        logger.info("saludando a " + nombre);
        return apiService.saludar(nombre);
    }

    @GetMapping("/crear/{nombre}")
    public String crear(@PathVariable("nombre") String nombre){
        logger.info("creando a " + nombre);
        apiService.crear(nombre);
        return "=)";
    }


}
