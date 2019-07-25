package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Saludo;
import org.springframework.stereotype.Service;

@Service("ApiService")
public class ApiServiceImpl implements ApiService{
    @Override
    public Saludo saludar(String nombre) {
        return new Saludo(nombre, "Hola " + nombre);
    }
}
