package edu.apimagic.delivery.controllers;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.use_cases.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.parseLong;
import static org.springframework.http.HttpStatus.OK;

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
            GetCategoryByName getCategoryByName, GetCategoryByCodeAndName getCategoryByCodeAndName
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
        final List<Category> categories = this.getCategoryByCodeAndName.execute(code, name);
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categoriesByName/{name}")
    public ResponseEntity<List<Category>> findByName(@PathVariable String name) {
        final List<Category> categories = this.getCategoryByName.execute(name);
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list() {
        final List<Category> categories = this.findAllCategories.execute();
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categoriesByCode/{code}")
    public ResponseEntity<List<Category>> findByCode(@PathVariable String code) {
        final List<Category> categories = this.getCategoryByCode.execute(code);
        return this.responseOk(categories);
    }

    @PostMapping(path = "/categories", consumes = "application/json")
    public ResponseEntity<Long> create(@RequestBody Category category) {
        return this.responseOk(this.createCategory.execute(category.getName()));
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {

        final Optional<Category> categoria = this.getCategoryById.execute(parseLong(id));

        return categoria.map(category -> CategoriesController.this.responseOk(category)).orElse(this.responseNotFound());
    }

    private ResponseEntity responseOk(Object body) {
        return new ResponseEntity(body, OK);
    }

    private ResponseEntity<Object> responseNotFound() {
        return ResponseEntity.notFound().build();
    }


}
