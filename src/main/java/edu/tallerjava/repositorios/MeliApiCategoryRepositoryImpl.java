package edu.tallerjava.repositorios;

import edu.tallerjava.dto.MeliCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MeliApiCategoryRepositoryImpl implements MeliApiCategoryRepository{

    private RestTemplate restTemplate;

    public MeliApiCategoryRepositoryImpl(RestTemplateBuilder builder){
        restTemplate = builder.rootUri("https://api.mercadolibre.com").build();
    }

    public List<MeliCategory> findAll(){
        return getForObject("/sites/MLA/categories",
                new ParameterizedTypeReference<List<MeliCategory>>() {});
    }

    @Override
    public MeliCategory findByCode(String code) {
        return restTemplate.getForObject("/categories/" + code, MeliCategory.class);
    }

    /**
     * Permite obtener como respuesta de un get un List tipado
     * @param uri path del servicio
     * @param responseType un wrapper de una lista parametrizada
     * @param <T> el tipo de datos de los objetos de la lista resultado
     * @return Una lista de objetos del tipo T
     */
    protected <T> List<T> getForObject(String uri, ParameterizedTypeReference<List<T>> responseType) {
        return restTemplate.exchange(uri, HttpMethod.GET, null, responseType).getBody();
    }
}
