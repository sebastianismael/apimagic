package edu.apimagic.domain.usecases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCategories {

    private final CategoryGateway categoryGateway;

    public FindAllCategories(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<Category> execute() {
        return this.categoryGateway.findAll();
    }
}
