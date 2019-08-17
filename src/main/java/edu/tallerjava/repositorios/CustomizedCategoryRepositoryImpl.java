package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomizedCategoryRepositoryImpl implements CustomizedCategoryRepository {

    public List<Category> findByCode(String code) {
        List<Category> list = new LinkedList<>();

        Category c1 = new Category();
        c1.setCodigo("MLA5725");
        c1.setNombre("Accesorios para Vehículos");
        list.add(c1);

        return list;
    }
}
