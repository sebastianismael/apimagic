package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {

    @Autowired
    private ApiService apiService;

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list(){
        final List<Category> categories = apiService.findAll();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping(path = "/categories/{id}")
    public Category getCategory(@PathVariable String id){
        Optional<Category> categoria = apiService.getCategory(Long.parseLong(id));

        return categoria.orElseThrow(IllegalStateException::new);
    }


}
