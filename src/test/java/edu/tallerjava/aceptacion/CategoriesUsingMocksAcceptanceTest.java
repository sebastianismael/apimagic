package edu.tallerjava.aceptacion;

import edu.tallerjava.dto.MeliCategory;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import edu.tallerjava.repositorios.MeliApiCategoryRepository;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CategoriesUsingMocksAcceptanceTest extends AcceptanceTest{

    @MockBean
    private MeliApiCategoryRepository meliApiCategoryRepository;

    @Test
    public void findAll() {

        List<MeliCategory> list = new LinkedList<>();
        MeliCategory c1 = new MeliCategory();
        c1.setId("MLA5725");
        c1.setName("Accesorios para Vehículos");
        list.add(c1);
        MeliCategory c2 = new MeliCategory();
        c2.setId("MLA1403");
        c2.setName("Alimentos y Bebidas");
        list.add(c2);

        when(meliApiCategoryRepository.findAll()).thenReturn(list);

        final List results = this.restTemplate.getForObject(url + "/categories", List.class);
        assertThat(results).hasSize(2);
    }

}
