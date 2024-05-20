package edu.tallerjava.servicios;

import edu.tallerjava.dominio.CategoryDao;
import edu.tallerjava.dominio.modelo.Category;
import edu.tallerjava.dominio.servicios.ApiService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoriyServiceWithOutSpringTest {

    private ApiService service = new ApiService();
    private CategoryDao categoryRepository = mock(CategoryDao.class);

    @Test
    public void pruebaDelCreate(){
        List list = mock(List.class);
        when(list.size()).thenReturn(3);

        when(categoryRepository.findAll()).thenReturn(list);
        service.setCategoryDao(categoryRepository);

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
        service.setCategoryDao(categoryRepository);


        final List results = service.findAll();
        assertThat(results).hasSize(2);
    }

}
