package edu.tallerjava.services;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import edu.tallerjava.servicios.ApiServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoriyServiceWithOutSpringTest {

    private ApiServiceImpl service = new ApiServiceImpl();
    private CategoryRepository categoryRepository = mock(CategoryRepository.class);

    @Test
    public void pruebaDelCreate(){
        List list = mock(List.class);
        when(list.size()).thenReturn(3);

        when(categoryRepository.findAll()).thenReturn(list);
        service.setCategoryRepository(categoryRepository);

        final List<Category> categories = service.findAll();
        Assertions.assertThat(categories).hasSize(3);
    }

    @Test
    public void findAll() {

        List<Category> list = new LinkedList<>();
        Category c1 = new Category();
        c1.setCodigo("MLA5725");
        c1.setNombre("Accesorios para Vehículos");
        list.add(c1);
        Category c2 = new Category();
        c2.setCodigo("MLA1403");
        c2.setNombre("Alimentos y Bebidas");
        list.add(c2);

        when(categoryRepository.findAll()).thenReturn(list);
        service.setCategoryRepository(categoryRepository);


        final List results = service.findAll();
        assertThat(results).hasSize(2);
    }

}
