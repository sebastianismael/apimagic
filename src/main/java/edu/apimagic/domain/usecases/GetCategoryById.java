package edu.apimagic.domain.usecases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCategoryById {
    private final CategoryGateway categoryGateway;

    public GetCategoryById(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public Optional<Category> execute(Long id) {
        return this.categoryGateway.findById(id);
    }
}
