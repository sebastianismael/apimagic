package edu.tallerjava.presentacion;

import edu.tallerjava.dominio.modelo.Category;
import edu.tallerjava.dominio.servicios.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicController {

    private static Logger logger = LoggerFactory.getLogger(BasicController.class);
    @Autowired
    private ApiService apiService;

    @GetMapping(path = "/hi/{name}")
    public Hi saludar(@PathVariable("name") String name){
        logger.info("hello " + name);
        return apiService.hi(name);
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody Category usuario){
        logger.info("creating " + usuario.getNombre());
        apiService.create(usuario.getNombre());
        return "=)";
    }

    @GetMapping(path = "/isAlive")
    public String smoke(){
        return "=)";
    }
}
