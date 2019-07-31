package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Category;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;

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
        final List results = this.restTemplate.getForObject(url + "/categories", List.class);
        String uri = url + "/categories/" + ((Map)results.get(0)).get("id");

        final ResponseEntity<Category> responseEntity = this.restTemplate.getForEntity(uri, Category.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        final Category category = responseEntity.getBody();
        assertThat(category.getPermalink()).isEqualTo("http://home.mercadolibre.com.ar/vehiculos-accesorios/");
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void getInvalidCategory(){
        final ResponseEntity<Category> responseEntity = this.restTemplate.getForEntity(url + "/categories/9891", Category.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
