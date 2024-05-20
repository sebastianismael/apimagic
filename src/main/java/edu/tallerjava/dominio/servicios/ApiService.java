package edu.tallerjava.dominio.servicios;

import edu.tallerjava.presentacion.Hi;
import edu.tallerjava.dominio.modelo.Category;

import java.util.List;
import java.util.Optional;

public interface ApiService {

    Hi hi(String name);

    void create(String name);

    List<Category> findAll();

    List<Category> findByCode(String code);

    Optional<Category> getCategory(Long id);

    List<Category> findByName(String name);

    List<Category> findByCodeAndName(String code, String name);
}
