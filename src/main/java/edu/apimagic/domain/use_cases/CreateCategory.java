package edu.apimagic.domain.use_cases;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.output_boundaries.CategoryGateway;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Component
@Transactional(readOnly = true, propagation = SUPPORTS)
public class CreateCategory {

    private final CategoryGateway categoryGateway;

    public CreateCategory(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Transactional(readOnly = false, propagation = REQUIRED, rollbackFor = {Exception.class})
    public Long execute(String name) {
        final Category category = new Category();
        category.setCodigo("QUERTY");
        category.setNombre(name);
        this.categoryGateway.save(category);
        return category.getId();
    }
}
