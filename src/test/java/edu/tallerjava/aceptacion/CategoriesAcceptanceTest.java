package edu.tallerjava.aceptacion;

import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesAcceptanceTest extends AcceptanceTest{

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findAll(){
        final List results = this.restTemplate.getForObject(url + "/categories", List.class);
        assertThat(results).hasSize(2);
    }


}
