package edu.apimagic.domain.usecases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCategory {

    private final CategoryGateway categoryGateway;

    public GetCategory(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<Category> execute(String code) {
        return this.categoryGateway.findByCode(code);
    }
}
