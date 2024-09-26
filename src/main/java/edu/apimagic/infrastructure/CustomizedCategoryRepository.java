package edu.apimagic.infrastructure;

import edu.apimagic.domain.model.Category;

import java.util.List;

public interface CustomizedCategoryRepository {

    List<Category> findByCode(String code);

    List<Category> findByCodeAndName(String code, String name);
}
