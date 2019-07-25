package edu.tallerjava.persistencia;

import edu.tallerjava.modelo.Usuario;
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
        Usuario juan = new Usuario();
        juan.setNombre("juan");

        entityManager.persist(juan);
        assertThat(entityManager.find(Usuario.class, juan.getId())).isNotNull();
    }
}
