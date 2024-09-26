package edu.apimagic.domain.use_cases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCategoryByCode {

    private final CategoryGateway categoryGateway;

    public GetCategoryByCode(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<Category> execute(String code) {
        return this.categoryGateway.findByCode(code);
    }
}
