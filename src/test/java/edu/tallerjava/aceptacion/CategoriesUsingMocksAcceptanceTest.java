package edu.tallerjava.aceptacion;

import edu.tallerjava.domain.CategoryGateway;
import edu.tallerjava.domain.modelo.Category;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CategoriesUsingMocksAcceptanceTest extends AcceptanceTest {

    @MockBean
    private CategoryGateway categoryRepository;

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

        final List results = this.restTemplate.getForObject(this.url + "/categories", List.class);
        assertThat(results).hasSize(2);
    }

}
