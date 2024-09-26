package edu.tallerjava.servicios;

import edu.tallerjava.domain.CategoryGateway;
import edu.tallerjava.domain.modelo.Category;
import edu.tallerjava.domain.servicios.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriyServiceTest {

    @MockBean
    private CategoryGateway meliApiCategoryRepository;
    @Autowired
    private ApiService apiService;

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

        when(this.meliApiCategoryRepository.findAll()).thenReturn(list);

        final List results = this.apiService.findAll();
        assertThat(results).hasSize(2);
    }

}
