package edu.tallerjava.servicios;

import edu.tallerjava.domain.CategoryGateway;
import edu.tallerjava.domain.modelo.Category;
import edu.tallerjava.domain.servicios.ApiService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoriyServiceWithOutSpringTest {

    private final ApiService service = new ApiService();
    private final CategoryGateway categoryRepository = mock(CategoryGateway.class);

    @Test
    public void pruebaDelCreate() {
        final List list = mock(List.class);
        when(list.size()).thenReturn(3);

        when(this.categoryRepository.findAll()).thenReturn(list);
        this.service.setCategoryDao(this.categoryRepository);

        final List<Category> categories = this.service.findAll();
        Assertions.assertThat(categories).hasSize(3);
    }

    @Test
    public void findAll() {

        final List<Category> list = new LinkedList<>();
        final Category c1 = new Category();
        c1.setCodigo("MLA5725");
        c1.setNombre("Accesorios para Vehículos");
        list.add(c1);
        final Category c2 = new Category();
        c2.setCodigo("MLA1403");
        c2.setNombre("Alimentos y Bebidas");
        list.add(c2);

        when(this.categoryRepository.findAll()).thenReturn(list);
        this.service.setCategoryDao(this.categoryRepository);


        final List results = this.service.findAll();
        assertThat(results).hasSize(2);
    }

}
