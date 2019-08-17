package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Hi;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import edu.tallerjava.repositorios.MeliApiCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("ApiService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ApiServiceImpl implements ApiService{

    @Autowired private CategoryRepository categoryRepository;

    @Autowired private MeliApiCategoryRepository meliApiCategoryRepository;

    @Override
    public Hi hi(String name) {
        return new Hi(name, "Hola " + name);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void create(String name) {
        Category category = new Category();
        category.setCodigo("QUERTY");
        category.setNombre(name);
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {

        List<Category> categories = meliApiCategoryRepository.findAll().stream()
                .map(meliCategory -> new Category())
                .collect(Collectors.toList());
        return categories;
    }

    @Override
    public List<Category> findByCode(String code) {
        return categoryRepository.findByCode(code);
    }

    @Override
    public Optional<Category> getCategory(Long id) {
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

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
