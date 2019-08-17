package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;

import java.util.List;

public interface CustomizedCategoryRepository {

    List<Category> findByCode(String code);

    List<Category> findByCodeAndName(String code, String name);
}
