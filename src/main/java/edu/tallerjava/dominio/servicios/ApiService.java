package edu.tallerjava.dominio.servicios;

import edu.tallerjava.dominio.CategoryGateway;
import edu.tallerjava.dominio.modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.singletonMap;

@Service("ApiService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ApiService {

    @Autowired
    private CategoryGateway categoryGateway;

    public Map<String, String> hi(String name) {
        return singletonMap(name, "Hola " + name);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void create(String name) {
        final Category category = new Category();
        category.setCodigo("QUERTY");
        category.setNombre(name);
        this.categoryGateway.save(category);
    }

    public List<Category> findAll() {
        return this.categoryGateway.findAll();
    }

    public List<Category> findByCode(String code) {
        return this.categoryGateway.findByCode(code);
    }

    public Optional<Category> getCategory(Long id) {
        return this.categoryGateway.findById(id);
    }

    public List<Category> findByName(String name) {
        return this.categoryGateway.findByName(name);
    }

    public List<Category> findByCodeAndName(String code, String name) {
        return this.categoryGateway.findByCodeAndName(code, name);
    }

    public void setCategoryDao(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
}
