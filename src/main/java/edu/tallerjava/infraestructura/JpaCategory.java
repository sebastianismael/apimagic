package edu.tallerjava.infraestructura;

import edu.tallerjava.dominio.CategoryGateway;
import edu.tallerjava.dominio.modelo.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCategory implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    public JpaCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public List<Category> findByCode(String code) {
        return this.categoryRepository.findByCode(code);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findByCodeAndName(String code, String name) {
        return this.categoryRepository.findByCodeAndName(code, name);
    }
}
