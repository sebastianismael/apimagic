package edu.apimagic.domain.usecases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Component
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CreateCategory {

    @Autowired
    private CategoryGateway categoryGateway;

    @Transactional(readOnly = false, propagation = REQUIRED, rollbackFor = {Exception.class})
    public void execute(String name) {
        final Category category = new Category();
        category.setCodigo("QUERTY");
        category.setNombre(name);
        this.categoryGateway.save(category);
    }
}
