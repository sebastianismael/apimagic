package edu.tallerjava.persistencia;

import edu.tallerjava.SpringTest;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestConnection extends SpringTest {

    @Test
    public void testConnection(){
        assertThat(entityManager().isOpen()).isTrue();
    }
}
