package edu.apimagic.domain.usecases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCategoryByName {

    private final CategoryGateway categoryGateway;

    public GetCategoryByName(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<Category> execute(String name) {
        return this.categoryGateway.findByName(name);
    }
}
