package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CategoriesController {

    @GetMapping(path = "/categories")
    public List<Category> list(){
        List<Category> results = new LinkedList<>();
        Category c1 = new Category();
        c1.setId("MLA5725");
        c1.setName("Accesorios para Vehículos");
        results.add(c1);

        Category c2 = new Category();
        c2.setId("MLA1403");
        c2.setName("Alimentos y Bebidas");
        results.add(c2);

        return results;
    }
}
