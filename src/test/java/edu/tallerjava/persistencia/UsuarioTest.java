package edu.tallerjava.persistencia;

import edu.tallerjava.modelo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

    @Autowired
    private EntityManager entityManager;

    @Test @Transactional @Rollback
    public void save(){
        Category juan = new Category();
        juan.setName("juan");

        entityManager.persist(juan);
        assertThat(entityManager.find(Category.class, juan.getId())).isNotNull();
    }
}
