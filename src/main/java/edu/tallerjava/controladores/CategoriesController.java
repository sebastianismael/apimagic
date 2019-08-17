package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {

    @Autowired
    private ApiService apiService;


    @GetMapping(path = "/categoriesByCodeAndName/{code}/{name}")
    public ResponseEntity<List<Category>> findByCodeAndName(@PathVariable String code, @PathVariable String name){
        final List<Category> categories = apiService.findByCodeAndName(code, name);
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping(path = "/categoriesByName/{name}")
    public ResponseEntity<List<Category>> findByName(@PathVariable String name){
        final List<Category> categories = apiService.findByName(name);
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list(){
        final List<Category> categories = apiService.findAll();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping(path = "/categoriesByCode/{code}")
    public ResponseEntity<List<Category>> findByCode(@PathVariable String code){
        final List<Category> categories = apiService.findByCode(code);
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> create(){
        Category category = new Category();
        category.setId(6543L);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id){

        Optional<Category> categoria = apiService.getCategory(Long.parseLong(id));
        if(categoria.isPresent()){
            return new ResponseEntity(categoria.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
