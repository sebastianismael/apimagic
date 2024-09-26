package edu.apimagic.domain.usecases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCategoryByName {

    @Autowired
    private CategoryGateway categoryGateway;

    public List<Category> GetCategoryByName(String name) {
        return this.categoryGateway.findByName(name);
    }

    public List<Category> execute(String name) {
        return this.categoryGateway.findByName(name);
    }
}
