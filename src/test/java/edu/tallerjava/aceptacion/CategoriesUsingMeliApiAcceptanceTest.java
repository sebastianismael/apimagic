package edu.tallerjava.aceptacion;

import edu.tallerjava.dto.CategoryDto;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesUsingMeliApiAcceptanceTest extends AcceptanceTest{

    @Test
    public void findAll(){
        final List<CategoryDto> results = getForObject(url + "/categories", new ParameterizedTypeReference<List<CategoryDto>>() {});
        assertThat(results).hasSize(32);
        for(CategoryDto dto : results){
            assertThat(dto.getCodigo()).isNotEmpty();
            assertThat(dto.getNombre()).isNotEmpty();
        }
    }

    @Test
    public void getSingleCategory(){
        final List<CategoryDto> categories = getForObject(url + "/categories", new ParameterizedTypeReference<List<CategoryDto>>() {});

        String uriForOneCategory = url + "/categoriesByCode/" + categories.get(0).getCodigo();
        final ResponseEntity<CategoryDto> responseEntity = restTemplate.getForEntity(uriForOneCategory, CategoryDto.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        final CategoryDto category = responseEntity.getBody();
        assertThat(category.getPermalink()).isEqualTo("https://www.mercadolibre.com.ar/c/accesorios-para-vehiculos");
    }

}
