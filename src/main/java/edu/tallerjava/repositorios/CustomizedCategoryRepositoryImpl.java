package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomizedCategoryRepositoryImpl implements CustomizedCategoryRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Category> findByCode(String code) {
        return entityManager.createQuery("select c from Category c where c.codigo =:code")
                            .setParameter("code", code)
                            .getResultList();
    }
}
