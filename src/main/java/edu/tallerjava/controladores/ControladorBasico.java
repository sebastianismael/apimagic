package edu.tallerjava.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBasico {

    private static Logger logger = LoggerFactory.getLogger(ControladorBasico.class);

    @GetMapping("/saludar/{nombre}")
    public Saludo saludar(@PathVariable("nombre") String nombre){
        logger.info("saludando a " + nombre);
        return new Saludo(nombre, "Hola!");
    }


}
