package edu.apimagic.delivery;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.servicios.ApiService;
import edu.apimagic.domain.usecases.CreateCategory;
import edu.apimagic.domain.usecases.FindAllCategories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class CategoriesController {

    private final ApiService apiService;
    private final CreateCategory createCategory;
    private final FindAllCategories findAllCategories;

    public CategoriesController(ApiService apiService,
                                CreateCategory createCategory,
                                FindAllCategories findAllCategories
    ) {
        this.apiService = apiService;
        this.createCategory = createCategory;
        this.findAllCategories = findAllCategories;
    }

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
        final List<Category> categories = this.findAllCategories.execute();
        return this.responseOk(categories);
    }

    @GetMapping(path = "/categoriesByCode/{code}")
    public ResponseEntity<List<Category>> findByCode(@PathVariable String code) {
        final List<Category> categories = this.apiService.findByCode(code);
        return this.responseOk(categories);
    }

    @PostMapping(path = "/categories", consumes = "application/json")
    public ResponseEntity create(@RequestBody Category category) {
        return this.responseOk(this.createCategory.execute(category.getNombre()));
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {

        final Optional<Category> categoria = this.apiService.getCategory(Long.parseLong(id));

        return categoria.map(category -> CategoriesController.this.responseOk(category)).orElse(this.responseNotFound());
    }

    private ResponseEntity responseOk(Object body) {
        return new ResponseEntity(body, OK);
    }

    private ResponseEntity<Object> responseNotFound() {
        return ResponseEntity.notFound().build();
    }


}
