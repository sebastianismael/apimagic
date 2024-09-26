package edu.apimagic.persistence;

import edu.apimagic.domain.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback
    public void save() {
        final Category category = new Category();
        category.setName("juan");
        category.setCode("QUERTY");
        this.entityManager.persist(category);
        assertThat(this.entityManager.find(Category.class, category.getId())).isNotNull();
    }

    @Test
    @Sql("/sql/createCategories.sql")
    public void testPersistencia() {
        assertThat(this.entityManager.createQuery("from Category").getResultList()).hasSize(8);
    }
}
