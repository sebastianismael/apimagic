package edu.tallerjava.persistencia;

import edu.tallerjava.SpringTest;
import edu.tallerjava.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioTest extends SpringTest {

    @Test @Transactional @Rollback
    public void save(){
        Usuario juan = new Usuario();
        juan.setNombre("juan");

        entityManager().persist(juan);
        assertThat(entityManager().find(Usuario.class, juan.getId())).isNotNull();
    }
}
