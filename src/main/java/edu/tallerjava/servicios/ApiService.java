package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Saludo;

public interface ApiService {

    Saludo saludar(String nombre);

    void crear(String nombre);
}
