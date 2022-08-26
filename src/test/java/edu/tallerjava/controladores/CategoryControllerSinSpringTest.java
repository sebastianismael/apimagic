package edu.tallerjava.controladores;

import edu.tallerjava.dto.CategoryDto;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryControllerSinSpringTest {

    private ApiService apiService;
    private CategoriesController categoriesController;

    @Before
    public void init(){
        apiService = mock(ApiService.class);
        categoriesController = new CategoriesController(apiService);
    }

    @Test
    public void pruebaStatusOK(){
        CategoryDto category = mock(CategoryDto.class);
        when(apiService.findByCode("5575")).thenReturn(category);
        final ResponseEntity<List<Category>> responseEntity = categoriesController.findByCode("5575");

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
