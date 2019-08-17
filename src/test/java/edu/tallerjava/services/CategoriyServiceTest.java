package edu.tallerjava.services;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import edu.tallerjava.servicios.ApiServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoriyServiceTest {

    private ApiServiceImpl service = new ApiServiceImpl();

    @Test
    public void pruebaDelCreate(){
        List list = mock(List.class);
        when(list.size()).thenReturn(3);
        CategoryRepository categoryRepository =
                Mockito.mock(CategoryRepository.class);

        when(categoryRepository.findAll()).thenReturn(list);
        service.setCategoryRepository(categoryRepository);

        final List<Category> categories = service.findAll();
        Assertions.assertThat(categories).hasSize(3);
    }

}
