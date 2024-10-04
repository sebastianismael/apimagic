package edu.tallerjava.domain.model

import org.amshove.kluent.shouldNotBeNull
import org.assertj.core.api.Assertions.assertThat
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
open class UserTest {
    @Autowired
    private lateinit var entityManager: EntityManager

    @Test
    @Transactional
    @Rollback
    open fun save() {
        val juan = User()
        juan.name = "juan"
        entityManager.persist(juan)
        entityManager.find(User::class.java, juan.id).shouldNotBeNull()
    }
}