package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Category;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesAcceptanceTest extends AcceptanceTest{

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findAll(){
        final List results = this.restTemplate.getForObject(url + "/categories", List.class);
        assertThat(results).hasSize(8);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void getSingleCategory(){
        final Category category = this.restTemplate.getForObject(url + "/categories/1", Category.class);
        assertThat(category.getNombre()).isEqualTo("Accesorios para Vehículos");
    }

}
