package edu.tallerjava.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBasico {

    @GetMapping("/saludar")
    public Saludo saludar(){
        return new Saludo("Seba", "Hola!");
    }


    private class Saludo {
        public Saludo(String nombre, String saludo){
            this.nombre = nombre;
            this.saludo = saludo;
        }
        String nombre;
        String saludo;
    }

}
