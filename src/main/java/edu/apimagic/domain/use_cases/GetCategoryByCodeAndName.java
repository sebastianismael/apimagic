package edu.apimagic.domain.use_cases;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.output_boundaries.CategoryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCategoryByCodeAndName {
    private final CategoryGateway categoryGateway;

    public GetCategoryByCodeAndName(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<Category> execute(String code, String name) {
        return this.categoryGateway.findByCodeAndName(code, name);
    }
}
