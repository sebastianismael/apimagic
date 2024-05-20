package edu.tallerjava.infraestructura;

import edu.tallerjava.dominio.CategoryDao;
import edu.tallerjava.dominio.modelo.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryDaoImpl implements CategoryDao {

    private CategoryRepository categoryRepository;

    public CategoryDaoImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findByCode(String code) {
        return categoryRepository.findByCode(code);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findByCodeAndName(String code, String name) {
        return categoryRepository.findByCodeAndName(code, name);
    }
}
