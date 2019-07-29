package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Hi;

public interface ApiService {

    Hi hi(String name);

    void create(String name);
}
