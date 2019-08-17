package edu.tallerjava.repositorios;

import edu.tallerjava.dto.MeliCategory;

import java.util.List;

public interface MeliApiCategoryRepository {
    List<MeliCategory> findAll();
}
