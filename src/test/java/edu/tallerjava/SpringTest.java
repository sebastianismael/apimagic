package edu.tallerjava;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class SpringTest {

    @Autowired
    private EntityManager entityManager;

    protected EntityManager entityManager(){
        return entityManager;
    }
}
