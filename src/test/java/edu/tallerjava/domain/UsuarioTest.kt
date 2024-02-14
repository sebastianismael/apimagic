package edu.tallerjava.domain

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@SpringBootTest
open class UsuarioTest {
    @Autowired
    private lateinit var entityManager: EntityManager

    @Test
    @Transactional
    @Rollback
    open fun save() {
        val juan = Usuario()
        juan.nombre = "juan"
        entityManager.persist(juan)
        Assertions.assertThat(entityManager.find(Usuario::class.java, juan.id)).isNotNull
    }
}