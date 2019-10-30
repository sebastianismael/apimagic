package edu.tallerjava.controladores;

import edu.tallerjava.dto.CategoryDto;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class CategoriesController {

    @Autowired
    private ApiService apiService;


    @GetMapping(path = "/categoriesByCodeAndName/{code}/{name}")
    public ResponseEntity<List<Category>> findByCodeAndName(@PathVariable String code, @PathVariable String name){
        final List<Category> categories = apiService.findByCodeAndName(code, name);
        return responseOk(categories);
    }

    @GetMapping(path = "/categoriesByName/{name}")
    public ResponseEntity<List<Category>> findByName(@PathVariable String name){
        final List<Category> categories = apiService.findByName(name);
        return responseOk(categories);
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<CategoryDto>> list(){
        final List<CategoryDto> categories = apiService.findAll();
        return responseOk(categories);
    }

    @GetMapping(path = "/categoriesByCode/{code}")
    public ResponseEntity<List<Category>> findByCode(@PathVariable String code){
        final CategoryDto categoryDto = apiService.findByCode(code);
        return responseOk(categoryDto);
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> create(){
        Category category = new Category();
        category.setId(6543L);
        return responseOk(category);
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id){

        Optional<Category> categoria = apiService.getCategory(Long.parseLong(id));

        return categoria.map(new Function<Category, ResponseEntity>() {
            @Override
            public ResponseEntity apply(Category category) {
                return responseOk(category);
            }
        }).orElse(responseNotFound());
    }

    private ResponseEntity responseOk(Object body) {
        return new ResponseEntity(body, HttpStatus.OK);
    }

    private ResponseEntity<Object> responseNotFound() {
        return ResponseEntity.notFound().build();
    }



}
