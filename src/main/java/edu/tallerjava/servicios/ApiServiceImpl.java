package edu.tallerjava.servicios;

import edu.tallerjava.controladores.Hi;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ApiService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ApiServiceImpl implements ApiService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Hi hi(String name) {
        return new Hi(name, "Hola " + name);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void create(String name) {
        Category category = new Category();
        category.setId("QUERTY");
        category.setName(name);
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


}
