package edu.apimagic.aceptance;

import edu.apimagic.domain.model.Category;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

//@Transactional
// If your test is @Transactional, it will rollback the transaction at the end of each test method by default.
// However, as using this arrangement with either RANDOM_PORT or DEFINED_PORT implicitly provides a real servlet environment,
// HTTP client and server will run in separate threads, thus separate transactions.
// Any transaction initiated on the server won’t rollback in this case.
public class CategoriesAcceptanceTest extends AcceptanceTest {

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findByCodeAndName() {
        final List results = this.restTemplate.getForObject(this.url + "/categoriesByCodeAndName/MLA1071/Animales y Mascotas", List.class);
        assertThat(results).hasSize(1);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findByCode() {
        final List results = this.restTemplate.getForObject(this.url + "/categoriesByCode/MLA1071", List.class);
        assertThat(results).hasSize(1);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findByName() {
        final List results = this.restTemplate.getForObject(this.url + "/categoriesByName/Alimentos y Bebidas", List.class);
        assertThat(results).hasSize(1);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findAll() {
        final List results = this.getForObject(this.url + "/categories", new ParameterizedTypeReference<List<Category>>() {
        });
        assertThat(results).hasSize(8);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void getSingleCategory() {
        final List<Category> categories = this.getForObject(this.url + "/categories", new ParameterizedTypeReference<List<Category>>() {
        });
        final String uri = this.url + "/categories/" + categories.get(0).getId();

        final ResponseEntity<Category> responseEntity = this.restTemplate.getForEntity(uri, Category.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);

        final Category category = responseEntity.getBody();
        assertThat(category.getPermalink()).isEqualTo("http://home.mercadolibre.com.ar/vehiculos-accesorios/");
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void getInvalidCategory() {
        final ResponseEntity<Category> responseEntity = this.restTemplate.getForEntity(this.url + "/categories/9891", Category.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(NOT_FOUND);
    }

    @Test
    public void createCategory() {
        final Category newCategory = new Category();
        newCategory.setNombre("accesorios para limpieza felina");
        newCategory.setCodigo("AFG");
        newCategory.setPermalink("www.mercadolibre.com/klhjaK098GDSHKGADNJJK");
        final ResponseEntity<Long> responseEntity = this.restTemplate.postForEntity(this.url + "/categories", newCategory, Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(responseEntity.getBody()).isNotNull();
    }


}
