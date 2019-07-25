package edu.tallerjava.persistencia;

import edu.tallerjava.SpringTest;
import edu.tallerjava.modelo.Usuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioTest extends SpringTest {

    @Test
    public void save(){
        Usuario juan = new Usuario();
        juan.setNombre("juan");

        entityManager().persist(juan);

        assertThat(entityManager().find(Usuario.class, juan.getId())).isNotNull();
    }
}
