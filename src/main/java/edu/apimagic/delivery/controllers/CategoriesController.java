package edu.apimagic.delivery.controllers;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.use_cases.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
public class CategoriesController {

    private final CreateCategory createCategory;
    private final FindAllCategories findAllCategories;
    private final GetCategoryByCode getCategoryByCode;
    private final GetCategoryById getCategoryById;
    private final GetCategoryByName getCategoryByName;
    private final GetCategoryByCodeAndName getCategoryByCodeAndName;

    public CategoriesController(
            CreateCategory createCategory,
            FindAllCategories findAllCategories,
            GetCategoryByCode getCategoryByCode,
            GetCategoryById getCategoryById,
            GetCategoryByName getCategoryByName,
            GetCategoryByCodeAndName getCategoryByCodeAndName
    ) {
        this.createCategory = createCategory;
        this.findAllCategories = findAllCategories;
        this.getCategoryByCode = getCategoryByCode;
        this.getCategoryById = getCategoryById;
        this.getCategoryByName = getCategoryByName;
        this.getCategoryByCodeAndName = getCategoryByCodeAndName;
    }

    @GetMapping(path = "/categoriesByCodeAndName/{code}/{name}")
    public ResponseEntity<List<Category>> findByCodeAndName(@PathVariable String code, @PathVariable String name) {
        return this.responseOk(this.getCategoryByCodeAndName.execute(code, name));
    }

    @GetMapping(path = "/categoriesByName/{name}")
    public ResponseEntity<List<Category>> findByName(@PathVariable String name) {
        return this.responseOk(this.getCategoryByName.execute(name));
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list() {
        return this.responseOk(this.findAllCategories.execute());
    }

    @GetMapping(path = "/categoriesByCode/{code}")
    public ResponseEntity<List<Category>> findByCode(@PathVariable String code) {
        return this.responseOk(this.getCategoryByCode.execute(code));
    }

    @PostMapping(path = "/categories", consumes = "application/json")
    public ResponseEntity<Long> create(@RequestBody Category category) {
        return this.responseOk(this.createCategory.execute(category.getName()));
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {
        return this.getCategoryById.execute(parseLong(id))
                .map(category -> this.responseOk(category))
                .orElse(this.responseNotFound());
    }

    private ResponseEntity responseOk(Object body) {
        return new ResponseEntity(body, OK);
    }

    private ResponseEntity responseNotFound() {
        return notFound().build();
    }


}
