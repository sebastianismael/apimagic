package edu.tallerjava.infraestructura;

import edu.tallerjava.domain.modelo.Category;

import java.util.List;

public interface CustomizedCategoryRepository {

    List<Category> findByCode(String code);

    List<Category> findByCodeAndName(String code, String name);
}
