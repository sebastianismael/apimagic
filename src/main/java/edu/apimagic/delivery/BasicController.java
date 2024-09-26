package edu.apimagic.delivery;

import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.servicios.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BasicController {

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);
    @Autowired
    private ApiService apiService;

    @GetMapping(path = "/hi/{name}")
    public Hi saludar(@PathVariable("name") String name) {
        logger.info("hello " + name);
        final Map<String, String> hi = this.apiService.hi(name);
        return new Hi(name, hi.get(name));
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody Category usuario) {
        logger.info("creating " + usuario.getNombre());
        this.apiService.create(usuario.getNombre());
        return "=)";
    }

    @GetMapping(path = "/isAlive")
    public String smoke() {
        return "=)";
    }
}
