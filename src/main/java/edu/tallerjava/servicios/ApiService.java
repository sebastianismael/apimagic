package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Hi;
import edu.tallerjava.modelo.Category;

import java.util.List;

public interface ApiService {

    Hi hi(String name);

    void create(String name);

    List<Category> findAll();
}
