package edu.tallerjava.infraestructura;

import edu.tallerjava.dominio.modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomizedCategoryRepositoryImpl implements CustomizedCategoryRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Category> findByCode(String code) {
        return entityManager.createQuery("from Category c where c.codigo =:code")
                            .setParameter("code", code)
                            .getResultList();
    }

    @Override
    public List<Category> findByCodeAndName(String code, String name) {
        return entityManager.createNamedQuery("findCategoryByCodeAndName")
                            .setParameter("code", code)
                            .setParameter("name", name)
                            .getResultList();
    }
}
