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

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list(){
        final List<Category> categories = apiService.findAll();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping(path = "/categorias")
    public ResponseEntity<List<Category>> todas(){
        final List<Category> categories = apiService.buscarTodos();
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
