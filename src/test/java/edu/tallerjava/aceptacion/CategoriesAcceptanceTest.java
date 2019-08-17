package edu.tallerjava.aceptacion;

import edu.tallerjava.modelo.Category;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@Transactional
// If your test is @Transactional, it will rollback the transaction at the end of each test method by default.
// However, as using this arrangement with either RANDOM_PORT or DEFINED_PORT implicitly provides a real servlet environment,
// HTTP client and server will run in separate threads, thus separate transactions.
// Any transaction initiated on the server won’t rollback in this case.
public class CategoriesAcceptanceTest extends AcceptanceTest{

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findByCodeAndName(){
        final List results = restTemplate.getForObject(url + "/categoriesByCodeAndName/MLA1071/Animales y Mascotas", List.class);
        assertThat(results).hasSize(1);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void findByName(){
        final List results = restTemplate.getForObject(url + "/categoriesByName/Alimentos y Bebidas", List.class);
        assertThat(results).hasSize(1);
    }

    @Test
    @Sql(value = "/sql/createCategories.sql")
    public void getInvalidCategory(){
        final ResponseEntity<Category> responseEntity = restTemplate.getForEntity(url + "/categories/9891", Category.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void createCategory(){
        Category newCategory = new Category();
        newCategory.setNombre("accesorios para limpieza felina");
        newCategory.setCodigo("AFG");
        newCategory.setPermalink("www.mercadolibre.com/klhjaK098GDSHKGADNJJK");
        final ResponseEntity<Category> responseEntity = restTemplate
                .postForEntity(url + "/categories", newCategory, Category.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getId()).isNotNull();
    }






}
