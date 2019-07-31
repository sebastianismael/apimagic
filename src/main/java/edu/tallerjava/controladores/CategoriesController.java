package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Category> list(){
        return apiService.findAll();
    }

    @GetMapping(path = "/categories/{id}")
    public Category getCategory(@PathVariable String id){
        Optional<Category> categoria = apiService.getCategory(Long.parseLong(id));

        return categoria.orElseThrow(IllegalStateException::new);
    }


}
