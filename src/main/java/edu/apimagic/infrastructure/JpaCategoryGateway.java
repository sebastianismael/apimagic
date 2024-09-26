package edu.apimagic.infrastructure;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCategoryGateway implements CategoryGateway {

    private final CategoryJpaRepository categoryJpaRepository;

    public JpaCategoryGateway(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public void save(Category category) {
        this.categoryJpaRepository.save(category);
    }

    @Override
    public List<Category> findByCode(String code) {
        return this.categoryJpaRepository.findByCode(code);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryJpaRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return this.categoryJpaRepository.findById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return this.categoryJpaRepository.findByName(name);
    }

    @Override
    public List<Category> findByCodeAndName(String code, String name) {
        return this.categoryJpaRepository.findByCodeAndName(code, name);
    }
}
