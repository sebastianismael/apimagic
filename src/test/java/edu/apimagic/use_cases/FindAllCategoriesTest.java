package edu.apimagic.use_cases;

import edu.apimagic.domain.CategoryGateway;
import edu.apimagic.domain.model.Category;
import edu.apimagic.domain.use_cases.FindAllCategories;
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
public class FindAllCategoriesTest {

    @MockBean
    private CategoryGateway meliApiCategoryRepository;
    @Autowired
    private FindAllCategories findAllCategories;

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

        when(this.meliApiCategoryRepository.findAll()).thenReturn(list);

        final List results = this.findAllCategories.execute();
        assertThat(results).hasSize(2);
    }

}
