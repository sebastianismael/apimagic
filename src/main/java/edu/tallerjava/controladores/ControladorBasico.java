package edu.tallerjava.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBasico {

    @GetMapping("/saludar/{nombre}")
    public Saludo saludar(@PathVariable("nombre") String nombre){
        return new Saludo(nombre, "Hola!");
    }


}
