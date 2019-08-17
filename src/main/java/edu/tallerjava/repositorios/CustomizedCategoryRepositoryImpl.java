package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository("CustomizedCategoryRepositoryImpl")
public class CustomizedCategoryRepositoryImpl implements CustomizedCategoryRepository {

    public List<Category> buscarTodos() {
        List<Category> list = new LinkedList<>();

        Category c1 = new Category();
        c1.setCodigo("MLA5725");
        c1.setNombre("Accesorios para Vehículos");
        list.add(c1);

        Category c2 = new Category();
        c2.setCodigo("MLA1403");
        c2.setNombre("Alimentos y Bebidas");
        list.add(c2);

        return list;
    }
}
