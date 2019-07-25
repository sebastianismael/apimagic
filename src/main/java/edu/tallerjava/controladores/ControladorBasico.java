package edu.tallerjava.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBasico {

    @GetMapping("/saludar")
    public Saludo saludar(){
        return new Saludo("Seba", "Hola!");
    }


}
