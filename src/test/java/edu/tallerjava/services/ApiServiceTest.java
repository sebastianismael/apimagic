package edu.tallerjava.services;

import edu.tallerjava.dto.MeliCategory;
import edu.tallerjava.repositorios.MeliApiCategoryRepository;
import edu.tallerjava.servicios.ApiService;
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
public class ApiServiceTest {

    @MockBean
    private MeliApiCategoryRepository meliApiCategoryRepository;
    @Autowired
    private ApiService apiService;

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

        final List results = apiService.findAll();
        assertThat(results).hasSize(2);
    }
}
