package edu.apimagic.domain.servicios;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ApiService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ApiService {

    @Autowired
    private CategoryGateway categoryGateway;

    public List<Category> findByName(String name) {
        return this.categoryGateway.findByName(name);
    }

    public List<Category> findByCodeAndName(String code, String name) {
        return this.categoryGateway.findByCodeAndName(code, name);
    }

}
