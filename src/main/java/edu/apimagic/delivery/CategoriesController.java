package edu.apimagic.delivery;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.servicios.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class CategoriesController {

    @Autowired
    private ApiService apiService;


    @GetMapping(path = "/categoriesByCodeAndName/{code}/{name}")
    public ResponseEntity<List<Category>> findByCodeAndName(@PathVariable String code, @PathVariable String name) {
        final List<Category> categories = this.apiService.findByCodeAndName(code, name);
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categoriesByName/{name}")
    public ResponseEntity<List<Category>> findByName(@PathVariable String name) {
        final List<Category> categories = this.apiService.findByName(name);
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list() {
        final List<Category> categories = this.apiService.findAll();
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categoriesByCode/{code}")
    public ResponseEntity<List<Category>> findByCode(@PathVariable String code) {
        final List<Category> categories = this.apiService.findByCode(code);
        return this.responseOk(categories);
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> create() {
        final Category category = new Category();
        category.setId(6543L);
        return this.responseOk(category);
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {

        final Optional<Category> categoria = this.apiService.getCategory(Long.parseLong(id));

        return categoria.map(new Function<Category, ResponseEntity>() {
            @Override
            public ResponseEntity apply(Category category) {
                return CategoriesController.this.responseOk(category);
            }
        }).orElse(this.responseNotFound());
    }

    private ResponseEntity responseOk(Object body) {
        return new ResponseEntity(body, HttpStatus.OK);
    }

    private ResponseEntity<Object> responseNotFound() {
        return ResponseEntity.notFound().build();
    }


}
