package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    private ApiService apiService;

    @GetMapping(path = "/categories")
    public List<Category> list(){
        return apiService.findAll();
    }
}
