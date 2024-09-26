package edu.apimagic.infrastructure;

import edu.apimagic.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomizedCategoryRepositoryImpl implements CustomizedCategoryRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Category> findByCode(String code) {
        return this.entityManager.createQuery("from Category c where c.code =:code")
                .setParameter("code", code)
                .getResultList();
    }

    @Override
    public List<Category> findByCodeAndName(String code, String name) {
        return this.entityManager.createNamedQuery("findCategoryByCodeAndName")
                .setParameter("code", code)
                .setParameter("name", name)
                .getResultList();
    }
}
