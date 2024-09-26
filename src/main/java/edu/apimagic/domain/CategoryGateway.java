package edu.apimagic.domain;

import edu.apimagic.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryGateway {
    void save(Category category);

    List<Category> findByCode(String code);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Category> findByName(String name);

    List<Category> findByCodeAndName(String code, String name);
}