package edu.tallerjava.controladores;

import edu.tallerjava.dto.CategoryDto;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {
    @MockBean
    private ApiService apiService;
    @Autowired
    private CategoriesController categoriesController;

    @Test
    public void pruebaStatusOK(){
        CategoryDto lista = mock(CategoryDto.class);
        when(apiService.findByCode("5575")).thenReturn(lista);
        final ResponseEntity<List<Category>> responseEntity = categoriesController.findByCode("5575");

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
