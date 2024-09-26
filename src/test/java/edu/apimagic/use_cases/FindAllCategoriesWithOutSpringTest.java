package edu.apimagic.use_cases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.use_cases.FindAllCategories;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindAllCategoriesWithOutSpringTest {

    private FindAllCategories findAllCategories;
    private CategoryGateway categoryRepository;

    @Before
    public void init() {
        this.categoryRepository = mock(CategoryGateway.class);
        this.findAllCategories = new FindAllCategories(this.categoryRepository);
    }

    @Test
    public void pruebaDelCreate() {
        final List list = mock(List.class);
        when(list.size()).thenReturn(3);

        when(this.categoryRepository.findAll()).thenReturn(list);

        final List<Category> categories = this.findAllCategories.execute();
        Assertions.assertThat(categories).hasSize(3);
    }

    @Test
    public void findAll() {

        final List<Category> list = new LinkedList<>();
        final Category c1 = new Category();
        c1.setCode("MLA5725");
        c1.setName("Accesorios para Vehículos");
        list.add(c1);
        final Category c2 = new Category();
        c2.setCode("MLA1403");
        c2.setName("Alimentos y Bebidas");
        list.add(c2);

        when(this.categoryRepository.findAll()).thenReturn(list);

        final List results = this.findAllCategories.execute();
        assertThat(results).hasSize(2);
    }

}
